package com.example.schedule.domain.board.service;

import com.example.schedule.domain.board.dto.responseDto.BoardResponseDto;
import com.example.schedule.domain.board.dto.responseDto.BoardWithIdResponseDto;
import com.example.schedule.domain.board.entity.Board;
import com.example.schedule.domain.common.exception.NotFoundException;
import com.example.schedule.domain.member.entity.Member;
import com.example.schedule.domain.board.repository.BoardRepository;
import com.example.schedule.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    // 게시글 생성 (메서드 호출할 때 매개변수 순서 주의해서 넣기)
    public BoardResponseDto save(String username, String title, String contents) {

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
    public BoardWithIdResponseDto findById(Long id) {
        Board findBoard = boardRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("존재하지 않는 id입니다: " + id)
            );

        return new BoardWithIdResponseDto(findBoard.getTitle(), findBoard.getContents());
    }

    /*
     특정 게시글 수정
    비밀번호 확인 후 게시글 수정 기능
    @Transactional로 하나의 트랜잭션 내에서 동작하게끔 만들어줌
     */
    @Transactional
    public void updateBoard(Long id, String newTitle, String newContents) {

        // 게시글 찾기
        Board findboard = boardRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("존재하지 않는 id입니다: " + id)
            );

        // 게시글 수정
        findboard.updateBoard(newTitle, newContents);
    }

    // 특정 게시글 삭제 기능
    public void delete(Long id) {

        Board findBoard = boardRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("존재하지 않는 id입니다: " + id)
            );

        boardRepository.delete(findBoard);
    }
}