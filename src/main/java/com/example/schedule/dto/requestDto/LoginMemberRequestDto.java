package com.example.schedule.dto.requestDto;

import lombok.Getter;

@Getter
public class LoginMemberRequestDto {
    // 이메일(로그인 시 아이디 역할)
    private final String email;

    // 비밀번호(로그인 시 비밀번호 역할)
    private final String password;


    // 로그인
    public LoginMemberRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
