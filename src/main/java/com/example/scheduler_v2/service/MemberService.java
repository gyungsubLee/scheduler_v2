package com.example.scheduler_v2.service;

import com.example.scheduler_v2.dto.MemberResponseDto;
import com.example.scheduler_v2.dto.SignUpResponseDto;
import com.example.scheduler_v2.entity.Member;
import com.example.scheduler_v2.repository.MemberRepository;
import com.example.scheduler_v2.util.PasswordEncoder;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public SignUpResponseDto signUp(String username, String email, String password) {

        // 비밀번호 해상 후 저장
        String hashedPassword = PasswordEncoder.encode(password);
        Member member = new Member(username, email, hashedPassword);

        Member saveMember = memberRepository.save(member);

        return new SignUpResponseDto(saveMember.getId(), saveMember.getUsername(), saveMember.getEmail());
    }

    public Member login(String email, String password) {
        Member findMember = memberRepository.findByEmailOrElseThrow(email);

        if(!PasswordEncoder.matches(password, findMember.getPassword())){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        return findMember;
    }


    public MemberResponseDto findById(Long id) {
        Member findMember = memberRepository.findByIdOrElseThrow(id);

        return new MemberResponseDto(findMember.getUsername(), findMember.getEmail());
    }


    @Transactional
    public MemberResponseDto updateMember(Long id, String username) {

        Member findMember = memberRepository.findByIdOrElseThrow(id);

        findMember.update(username);

        return new MemberResponseDto(findMember.getUsername(), findMember.getEmail());
    }

    public void delete(Long id) {

        Member findMember = memberRepository.findByIdOrElseThrow(id);

        memberRepository.delete(findMember);
    }


}
