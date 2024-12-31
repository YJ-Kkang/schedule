package com.example.schedule.dto.responseDto;

import com.example.schedule.entity.Member;
import lombok.Getter;

@Getter
public class MemberResponseDto {

    private final Long id;

    private final String username;

    private final String email;

    // 전체 회원 조회
    public static MemberResponseDto toDto(Member member) {
        return new MemberResponseDto(
                member.getId(),
                member.getUsername(),
                member.getEmail()
        );
    }

    // 특정 회원 조회
    public MemberResponseDto(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }


}