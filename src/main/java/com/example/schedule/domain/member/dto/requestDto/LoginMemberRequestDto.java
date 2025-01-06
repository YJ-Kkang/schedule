package com.example.schedule.domain.member.dto.requestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LoginMemberRequestDto {
    // 이메일(로그인 시 아이디 역할)
    @NotBlank(message = "이메일은 필수 입력값입니다.")
    @Email
    private final String email;

    // 비밀번호(로그인 시 비밀번호 역할)
    @NotBlank(message = "비밀번호는 필수 입력값입니다.")
    private final String password;


    // 로그인
    public LoginMemberRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
