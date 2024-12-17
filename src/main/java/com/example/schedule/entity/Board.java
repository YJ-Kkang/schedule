package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "board")
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    // 1명의 회원은 여러 개의 게시글 작성 가능 ( N 대 1 단방향 관계 )
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

}