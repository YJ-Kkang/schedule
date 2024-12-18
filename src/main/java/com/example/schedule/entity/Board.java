package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "board")
public class Board extends BaseEntity {

    // ID (자동 생성)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 할 일 제목
    @Column(nullable = false)
    private String title;

    // 할 일 내용
    @Column(columnDefinition = "longtext")
    private String contents;

    // 1명의 회원이 여러 개의 게시글 작성 가능 ( N 대 1 단방향 관계 )
    @Setter
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Board() {
    }

    public Board(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    // 게시글 수정
    public void updateBoard(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

}