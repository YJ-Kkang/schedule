package com.example.schedule.domain.board.dto.requestDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@NotBlank
@Getter
public class CreateBoardRequestDto {

    // 할 일 제목
    @NotBlank(message = "제목은 필수 입력값입니다.")
    private final String title;

    // 할 일 내용
    @NotBlank(message = "내용은 필수 입력값입니다.")
    private final String contents;

    /*
    작성 유저명
    어떤 회원이 작성했는지 요청 정보에 담겨 있어야 하기에 username 요청
    @Pattern(regexp = "^[가-힣a-zA-Z0-9]{2,10}]$" , message = "유저명은 특수문자를 포함하지 않은 2~10자리로 생성할 수 있습니다.")
    위 어노테이션은 생략. 회원가입할 때 @Pattern 적용됐다면 여기에서는 안 적어도 될 것 같음.
     */
    @NotBlank(message = "유저명은 필수 입력값입니다.")
    private final String username;

    // 게시글 생성
    public CreateBoardRequestDto(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }

}