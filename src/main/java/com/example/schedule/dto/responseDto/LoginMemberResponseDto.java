package com.example.schedule.dto.responseDto;

import lombok.Getter;

@Getter
public class LoginMemberResponseDto {
    Long id;

    public LoginMemberResponseDto(Long id) {
        this.id = id;
    }
}