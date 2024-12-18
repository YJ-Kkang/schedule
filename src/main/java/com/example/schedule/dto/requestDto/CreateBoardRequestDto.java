package com.example.schedule.dto.requestDto;

import lombok.Getter;

@Getter
public class CreateBoardRequestDto {

    // 할 일 제목
    private final String title;

    // 할 일 내용
    private final String contents;

    /*
    작성 유저명
    어떤 회원이 작성했는지 요청 정보에 담겨 있어야 하기에 username 요청
     */
    private final String username;

    // 게시글 생성
    public CreateBoardRequestDto(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }

}