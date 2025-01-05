package com.example.schedule.domain.board.dto.responseDto;

import lombok.Getter;

@Getter
public class BoardWithIdResponseDto {

    private final String title;

    private final String contents;

    public BoardWithIdResponseDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

}