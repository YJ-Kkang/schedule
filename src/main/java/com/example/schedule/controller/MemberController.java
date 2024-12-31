package com.example.schedule.controller;

import com.example.schedule.dto.requestDto.LoginMemberRequestDto;
import com.example.schedule.dto.requestDto.SignUpMemberRequestDto;
import com.example.schedule.dto.requestDto.UpdateMemberRequestDto;
import com.example.schedule.dto.responseDto.LoginMemberResponseDto;
import com.example.schedule.dto.responseDto.MemberResponseDto;
import com.example.schedule.dto.responseDto.SignUpMemberResponseDto;
import com.example.schedule.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 회원 생성(회원 가입)
    @PostMapping("/signup")
    public ResponseEntity<SignUpMemberResponseDto> signUp(@RequestBody SignUpMemberRequestDto requestDto) {

        SignUpMemberResponseDto signUpResponseDto =
                memberService.signUp(
                        requestDto.getUsername(),
                        requestDto.getEmail(),
                        requestDto.getPassword()
                );

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody LoginMemberRequestDto requestDto,
            HttpServletRequest request
    ) {
        LoginMemberResponseDto responseDto =
                memberService.signIn(
                        requestDto.getEmail(),
                        requestDto.getPassword()
                );

        // id 찾아옴
        Long id = responseDto.getId();
        // 세션 만듦
        HttpSession session = request.getSession();

        MemberResponseDto dto = memberService.findById(id);

        // 세션 객체에 저장(사용자의 정보를 저장)
        session.setAttribute("member", dto);

        return new ResponseEntity<>("Sign in successfully.", HttpStatus.OK);
    }

    // 회원 전체 조회
    @GetMapping
    public ResponseEntity<List<MemberResponseDto>> findAll() {

        List<MemberResponseDto> memberResponseDto = memberService.findAll();

        return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }

    // 특정 회원 조회
    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> findById(@PathVariable Long id) {

        MemberResponseDto memberResponseDto = memberService.findById(id);

        return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }

    /* 회원 정보 수정
    비밀번호 확인 후 회원 정보 수정 기능
    일부 수정이기에 PatchMapping 사용
     */
    @PatchMapping("/{id}")
    public ResponseEntity<String> updateMember(
            @PathVariable Long id,
            @RequestBody UpdateMemberRequestDto requestDto
    ) {
        memberService.updateMember(
                id,
                requestDto.getPassword(),
                requestDto.getUsername()
        );

        return new ResponseEntity<>("Your account information has been updated successfully.", HttpStatus.OK);
    }

    // 특정 회원 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);

        return new ResponseEntity<>("The member information has been deleted successfully.", HttpStatus.OK);

    }

}