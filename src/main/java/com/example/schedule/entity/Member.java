package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "member")
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    // 기본 생성자
    public Member() {
    }

    // 회원 정보 구성
    public Member(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // 회원 정보 수정
    public void updateMember(String username, String email) {
        this.username = username;
        this.email = email;
    }

}