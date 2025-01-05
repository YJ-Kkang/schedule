package com.example.schedule.domain.board.repository;

import com.example.schedule.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface BoardRepository extends JpaRepository<Board, Long> {

    // 게시글 조회, 수정, 삭제
    default Board findByIdOrElseThrow(Long id) {              //todo 예외처리 모두 서비스단으로 넘기기
        return findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Does not exist id = " + id));
    }

}