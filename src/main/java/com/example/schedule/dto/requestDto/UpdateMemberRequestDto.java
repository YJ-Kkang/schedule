package com.example.schedule.dto.requestDto;

import lombok.Getter;

@Getter
public class UpdateMemberRequestDto {

    // 기존 비밀번호 (비밀번호 확인용)
    private final String password;

    // 새로운 유저명
    private final String username;

   // 새로운 이메일
    private final String email;

    public UpdateMemberRequestDto(String password, String username, String email) {
        this.password = password;
        this.username = username;
        this.email = email;
    }
}