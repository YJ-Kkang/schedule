package com.example.schedule.repository;

import com.example.schedule.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findMemberByUsername(String username);

    // 게시글 생성
    default Member findMemberByUsernameOrElseThrow(String username) {
        return findMemberByUsername(username)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "Does not exist username = " + username
                        )
                );
    }

    // 회원 정보 수정, 삭제
    default Member findByIdOrElseThrow(Long id) {
        return findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "Does not exist id = " + id
                        )
                );
    }

    // 이메일로 찾기
    Optional<Member> findByEmail(String email);

}
