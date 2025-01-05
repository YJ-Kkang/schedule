package com.example.schedule.domain.board.dto.responseDto;

import com.example.schedule.domain.board.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponseDto {

    private final Long id;

    // 할 일 제목
    private final String title;

    // 할 일 내용
    private final String contents;

    // 게시글 생성
    public BoardResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

    public static BoardResponseDto toDto(Board board) {
        return new BoardResponseDto(board.getId(), board.getTitle(), board.getContents());
    }
}