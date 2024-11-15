package com.example.scheduler_v2.repository;

import com.example.scheduler_v2.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
