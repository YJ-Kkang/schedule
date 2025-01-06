package com.example.schedule.domain.member.dto.requestDto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

// 역직렬화(제이슨 타입을 자바 객체로 바꾸는 것)
@Getter
public class SignUpMemberRequestDto {

    // @NotBlank 띄어쓰기금지 (메시지는 로그에 뜸)
    @NotBlank(message = "유저명은 필수 입력값입니다.")
    private final String username;

    @NotBlank(message = "이메일은 필수 입력값입니다.")
    @Email
    private final String email;

    @NotBlank(message = "비밀번호는 필수 입력값입니다.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$"
        , message = "비밀번호는 영문 대, 소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8 ~ 20자여야 합니다.")
    private final String password;


    // 역직렬화에서 @JsonCreator가 최우선 순위로 실행됨.
    @JsonCreator
    public SignUpMemberRequestDto(
        @JsonProperty("username") String username,
        @JsonProperty("email") String email,
        @JsonProperty("password") String password
    ) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}