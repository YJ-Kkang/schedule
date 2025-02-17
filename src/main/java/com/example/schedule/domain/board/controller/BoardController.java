package com.example.schedule.domain.board.controller;

import com.example.schedule.domain.board.dto.requestDto.CreateBoardRequestDto;
import com.example.schedule.domain.board.dto.requestDto.UpdateBoardRequestDto;
import com.example.schedule.domain.board.dto.responseDto.BoardResponseDto;
import com.example.schedule.domain.board.dto.responseDto.BoardWithIdResponseDto;
import com.example.schedule.domain.board.service.BoardService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    // 게시글 생성
    @PostMapping
    public ResponseEntity<BoardResponseDto> save(
        @RequestBody CreateBoardRequestDto requestDto
    ) {
        
        // 게시글 생성 로직
        BoardResponseDto boardResponseDto =
                boardService.save(
                        requestDto.getUsername(),
                        requestDto.getTitle(),
                        requestDto.getContents()
                );

        return new ResponseEntity<>(boardResponseDto, HttpStatus.CREATED);
    }

    // 게시글 전체 조회
    @GetMapping
    public ResponseEntity<List<BoardResponseDto>> findAll() {

        List<BoardResponseDto> boardResponseDtoList = boardService.findAll();

        return new ResponseEntity<>(boardResponseDtoList, HttpStatus.OK);
    }

    // 특정 게시글 조회
    @GetMapping("/{id}")
    public ResponseEntity<BoardWithIdResponseDto> findById(
        @PathVariable Long id
    ) {

        BoardWithIdResponseDto boardWithAgeResponseDto = boardService.findById(id);

        return new ResponseEntity<>(boardWithAgeResponseDto, HttpStatus.OK);
    }

    /*
    특정 게시글 수정
    비밀번호 확인 후 게시글 수정 기능
    일부 수정이기에 PatchMapping 사용
     */
    @PatchMapping("/{id}")
    public ResponseEntity<String> updateBoard(
            @PathVariable Long id,
            @RequestBody UpdateBoardRequestDto UpdateBoardRequestDto
    ) {

        // 수정 로직
        boardService.updateBoard(
                id,
                UpdateBoardRequestDto.getTitle(),
                UpdateBoardRequestDto.getContents()
        );

        return new ResponseEntity<>("게시글 수정 완료", HttpStatus.OK);
    }



    // 특정 게시글 삭제 기능
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
        @PathVariable Long id
    ) {

        // 삭제 로직
        boardService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}