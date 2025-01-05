package com.example.schedule.domain.member.dto.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@NotBlank
@Getter
public class UpdateMemberRequestDto {

    // 기존 비밀번호 (비밀번호 확인용)
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=\\\\S+$).{8,20}"
        , message = "비밀번호는 영문 대, 소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8 ~ 20자여야 합니다.")
    private final String password;

    // 새로운 유저명
    @NotBlank(message = "유저명은 필수 입력값입니다.")
    @Pattern(regexp = "^[가-힣a-zA-Z0-9]{2,10}]$" , message = "유저명은 특수문자를 포함하지 않은 2~10자리로 생성할 수 있습니다.")
    private final String username;

    public UpdateMemberRequestDto(String password, String username) {
        this.password = password;
        this.username = username;
    }
}