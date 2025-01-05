package com.example.schedule.domain.board.dto.requestDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@NotBlank
@Getter
public class UpdateBoardRequestDto {

    // 새로운 제목
    @NotBlank(message = "제목은 필수 입력값입니다.")
    private final String title;

    // 새로운 내용
    @NotBlank(message = "내용은 필수 입력값입니다.")
    private final String contents;

    public UpdateBoardRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

}
