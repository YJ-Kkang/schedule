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

    @Column(nullable = false)
    private String password;

    private Integer age;

    // 기본 생성자
    public Member() {
    }

    // 회원 정보 구성
    public Member(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    // 비밀번호 수정
    public void updatePassword(String password) {
        this.password = password;
    }

}