package com.example.schedule.controller;

import com.example.schedule.dto.BoardResponseDto;
import com.example.schedule.dto.BoardWithAgeResponseDto;
import com.example.schedule.dto.CreateBoardRequestDto;
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
                        requestDto.getTitle(),
                        requestDto.getContents(),
                        requestDto.getUsername()
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
    public ResponseEntity<BoardWithAgeResponseDto> findById(@PathVariable Long id) {

        BoardWithAgeResponseDto boardWithAgeResponseDto = boardService.findById(id);

        return new ResponseEntity<>(boardWithAgeResponseDto, HttpStatus.OK);
    }

    // 특정 게시글 삭제 기능
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        boardService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}