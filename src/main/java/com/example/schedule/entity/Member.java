package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

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

    // 이메일
    @Column(nullable = false, unique = true)
    private String email;

    // 비밀번호
    @Column(nullable = false)
    private String password;

    // 작성일과 시간, 수정일과 시간 (자동 생성)
    @Column( )
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    // 기본 생성자
    public Member() {
    }

    // 회원 정보 구성
    public Member(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        //생성 시 현재 시간 설정
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }

    // 회원 정보 수정
    public void updateMember(String username, String email) {
        this.username = username;
        this.email = email;

        //업데이트 시 현재 시간 설정
        this.modifiedAt = LocalDateTime.now();
    }

}