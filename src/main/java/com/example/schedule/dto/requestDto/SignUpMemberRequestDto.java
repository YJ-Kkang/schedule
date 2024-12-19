package com.example.schedule.dto.requestDto;

import lombok.Getter;

@Getter
public class SignUpMemberRequestDto {

    private final String username;

    private final String email;

    private final String password;


    public SignUpMemberRequestDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}