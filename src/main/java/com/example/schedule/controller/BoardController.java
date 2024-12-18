package com.example.schedule.controller;

import com.example.schedule.dto.responseDto.BoardResponseDto;
import com.example.schedule.dto.responseDto.BoardWithIdResponseDto;
import com.example.schedule.dto.requestDto.CreateBoardRequestDto;
import com.example.schedule.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    // 게시글 생성
    @PostMapping
    public ResponseEntity<BoardResponseDto> save(@RequestBody CreateBoardRequestDto requestDto) {

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
    public ResponseEntity<BoardWithIdResponseDto> findById(@PathVariable Long id) {

        BoardWithIdResponseDto boardWithAgeResponseDto = boardService.findById(id);

        return new ResponseEntity<>(boardWithAgeResponseDto, HttpStatus.OK);
    }

    /*
     특정 게시글 수정
    비밀번호 확인 후 게시글 수정 기능
    일부 수정이기에 PatchMapping 사용
     */



    // 특정 게시글 삭제 기능
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        boardService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}