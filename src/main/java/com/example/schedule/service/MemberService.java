package com.example.schedule.service;

import com.example.schedule.dto.responseDto.MemberResponseDto;
import com.example.schedule.dto.responseDto.SignUpMemberResponseDto;
import com.example.schedule.entity.Member;
import com.example.schedule.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /* 회원 생성
    유저명: username
    이메일: email
    비밀번호: password
     */
    public SignUpMemberResponseDto signUp(String username, String email, String password) {

        Member member = new Member(username, email, password);

        Member savedMember = memberRepository.save(member);

        return new SignUpMemberResponseDto(savedMember.getId(), savedMember.getUsername(), savedMember.getEmail());
    }

    // 회원 전체 조회
    public List<MemberResponseDto> findAll() {
        return memberRepository.findAll()
                .stream()
                .map(MemberResponseDto::toDto)
                .toList();
    }

    // 특정 회원 조회
    public MemberResponseDto findById(Long id) {

        Optional<Member> optionalMember = memberRepository.findById(id);

        // NPE 방지
        if (optionalMember.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        Member findMember = optionalMember.get();

        return new MemberResponseDto(findMember.getUsername(), findMember.getEmail());
    }

    /*
    회원 정보 수정
    비밀번호 확인 후 회원 정보 수정 기능
    @Transactional로 하나의 트랜잭션 내에서 동작하게끔 만들어줌
     */
    @Transactional
    public void updateMember(Long id, String password, String newName) {

        // 회원 찾기
        Member findMember = memberRepository.findByIdOrElseThrow(id);

        // 비밀번호 확인
        if (!findMember.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "The password is incorrect.");
        }

        // 유저명 수정
        findMember.updateMember(newName);
    }

    // 특정 회원 삭제
    public void deleteMember(Long id) {
        Member findMember = memberRepository.findByIdOrElseThrow(id);
        memberRepository.delete(findMember);
    }
}