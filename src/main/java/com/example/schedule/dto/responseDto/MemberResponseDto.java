package com.example.schedule.dto.responseDto;

import lombok.Getter;

@Getter
public class MemberResponseDto {

    // 특정 회원 조회
    private final String username;

    public MemberResponseDto(String username) {
        this.username = username;
    }


}