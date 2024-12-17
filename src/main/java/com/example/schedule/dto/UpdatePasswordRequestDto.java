package com.example.schedule.dto;

import lombok.Getter;

@Getter
public class UpdatePasswordRequestDto {

    // 기존 비밀번호
    private final String oldPassword;

    // 새로운 비밀번호
    private final String newPassword;

    public UpdatePasswordRequestDto(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }
}