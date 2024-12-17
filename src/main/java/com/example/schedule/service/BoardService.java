package com.example.schedule.service;

import com.example.schedule.dto.BoardResponseDto;
import com.example.schedule.dto.BoardWithAgeResponseDto;
import com.example.schedule.entity.Board;
import com.example.schedule.entity.Member;
import com.example.schedule.repository.BoardRepository;
import com.example.schedule.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    public BoardResponseDto save(String title, String contents, String username) {

        Member findMember = memberRepository.findMemberByUsernameOrElseThrow(username);

        Board board = new Board(title, contents);
        board.setMember(findMember);

        boardRepository.save(board);

        return new BoardResponseDto(board.getId(), board.getTitle(), board.getContents());
    }

    // 게시글 전체 조회
    public List<BoardResponseDto> findAll() {
        return boardRepository.findAll()
                .stream()
                .map(BoardResponseDto::toDto)
                .toList();
    }

    // 특정 게시글 조회
    public BoardWithAgeResponseDto findById(Long id) {
        Board findBoard = boardRepository.findByIdOrElseThrow(id);
        Member writer = findBoard.getMember();

        return new BoardWithAgeResponseDto(findBoard.getTitle(), findBoard.getContents(), writer.getAge());
    }

    // 특정 게시글 삭제 기능
    public void delete(Long id) {

        Board findBoard = boardRepository.findByIdOrElseThrow(id);

        boardRepository.delete(findBoard);
    }
}