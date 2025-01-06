package com.example.schedule.domain.member.dto.requestDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateMemberRequestDto {

    // 기존 비밀번호 (비밀번호 확인용)
    private final String password;

    // 새로운 유저명
    @NotBlank(message = "유저명은 필수 입력값입니다.")
    private final String username;

    public UpdateMemberRequestDto(String password, String username) {
        this.password = password;
        this.username = username;
    }
}