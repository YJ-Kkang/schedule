package com.example.schedule.domain.member.dto.requestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@NotBlank
@Getter
public class LoginMemberRequestDto {
    // 이메일(로그인 시 아이디 역할)
    @NotBlank(message = "이메일은 필수 입력값입니다.")
    @Email
    private final String email;

    // 비밀번호(로그인 시 비밀번호 역할)
    @NotBlank(message = "비밀번호는 필수 입력값입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=\\\\S+$).{8,20}"
        , message = "비밀번호는 영문 대, 소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8 ~ 20자여야 합니다.")
    private final String password;


    // 로그인
    public LoginMemberRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
