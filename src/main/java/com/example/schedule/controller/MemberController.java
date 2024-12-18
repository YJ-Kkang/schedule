package com.example.schedule.controller;

import com.example.schedule.dto.requestDto.SignUpRequestDto;
import com.example.schedule.dto.requestDto.UpdateMemberRequestDto;
import com.example.schedule.dto.responseDto.MemberResponseDto;
import com.example.schedule.dto.responseDto.SignUpResponseDto;
import com.example.schedule.service.MemberService;
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

    // 회원 생성
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {

        SignUpResponseDto signUpResponseDto =
                memberService.signUp(
                        requestDto.getUsername(),
                        requestDto.getEmail(),
                        requestDto.getPassword()
                );

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
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
                id, requestDto.getPassword(),
                requestDto.getUsername(), requestDto.getEmail()
        );

        return new ResponseEntity<>("Your account information has been updated successfully.", HttpStatus.OK);
    }



}