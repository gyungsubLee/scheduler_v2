package com.example.scheduler_v2.repository;

import com.example.scheduler_v2.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    default Member findByIdOrElseThrow(Long id){
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, id + "에 해당하는 회원이 존재하지 않습니다."));
    }

    Optional<Member> findByEmail(String email);

    default Member findByEmailOrElseThrow(String email){
        return findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, email + "에 해당하는 회원이 존재하지 않습니다."));
    }
}
