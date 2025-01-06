package com.example.schedule.domain.board.dto.requestDto;

import lombok.Getter;

@Getter
public class UpdateBoardRequestDto {

    // 새로운 제목
    private final String title;

    // 새로운 내용
    private final String contents;

    public UpdateBoardRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

}
