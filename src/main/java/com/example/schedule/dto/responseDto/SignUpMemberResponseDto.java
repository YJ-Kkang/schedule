package com.example.schedule.dto.responseDto;

import lombok.Getter;

@Getter
public class SignUpMemberResponseDto {

    private final Long id;

    private final String username;

    private final String email;


    public SignUpMemberResponseDto(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}