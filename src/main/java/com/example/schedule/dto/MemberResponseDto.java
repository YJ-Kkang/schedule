package com.example.schedule.dto;

import lombok.Getter;

@Getter
public class MemberResponseDto {

    // 특정 회원 조회
    private final String username;
    private final Integer age;

    public MemberResponseDto(String username, Integer age) {
        this.username = username;
        this.age = age;
    }


}