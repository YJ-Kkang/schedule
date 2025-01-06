package com.example.schedule.domain.member.entity;

import com.example.schedule.domain.common.Entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "member")
public class Member extends BaseEntity {

    // ID (자동 생성)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     유저명
     null과 동명이인 금지하려면 -> @Column(nullable = false, unique = true)
     */
    @Column(nullable = false)
    private String username;

    // 이메일 / unique = true: 중복값 금지
    @Column(nullable = false, unique = true)
    private String email;

    // 비밀번호
    @Column(nullable = false)
    private String password;

    // 기본 생성자
    public Member() {
    }

    // 회원 정보 생성
    public Member(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // 회원 정보 수정
    public void updateMember(String username) {
        this.username = username;
    }

}