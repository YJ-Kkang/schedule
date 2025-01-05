package com.example.schedule.domain.member.dto.responseDto;

import lombok.Getter;

@Getter
public class LoginMemberResponseDto {
    Long id;

    public LoginMemberResponseDto(Long id) {
        this.id = id;
    }
}