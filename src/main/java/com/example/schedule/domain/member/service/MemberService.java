package com.example.schedule.domain.member.service;

import com.example.schedule.domain.common.exception.NotFoundException;
import com.example.schedule.domain.member.dto.responseDto.LoginMemberResponseDto;
import com.example.schedule.domain.member.dto.responseDto.MemberResponseDto;
import com.example.schedule.domain.member.dto.responseDto.SignUpMemberResponseDto;
import com.example.schedule.domain.member.entity.Member;
import com.example.schedule.domain.member.repository.MemberRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        // todo 같은 이메일 가입 막는 예외 추가

        Member member = new Member(username, email, password);

        Member savedMember = memberRepository.save(member);

        return new SignUpMemberResponseDto(savedMember.getId(), savedMember.getUsername(), savedMember.getEmail());
    }

    // 로그인
    public LoginMemberResponseDto signIn(String email, String password) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("존재하지 않는 이메일입니다.")
                );
        // isPasswordDifferent가 참일 때(패스워드가 다를 때) if문이 실행됨
        boolean isPasswordDifferent = !member.getPassword().equals(password);

        if(isPasswordDifferent) {
            throw new NotFoundException("존재하지 않는 비밀번호입니다.");
        }

        return new LoginMemberResponseDto(member.getId());
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
            throw new NotFoundException("존재하지 않는 id입니다: " + id);
        }

        Member member = optionalMember.get();

        return new MemberResponseDto(
                member.getId(),
                member.getUsername(),
                member.getEmail()
        );
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
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
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