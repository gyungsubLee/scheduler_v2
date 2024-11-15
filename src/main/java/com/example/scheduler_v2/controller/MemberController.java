package com.example.scheduler_v2.controller;


import com.example.scheduler_v2.dto.*;
import com.example.scheduler_v2.entity.Member;
import com.example.scheduler_v2.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@Valid  @RequestBody SignUpRequestDto requestDto){

        SignUpResponseDto signUpResponseDto = memberService.signUp(
                requestDto.getUsername(),
                requestDto.getEmail(),
                requestDto.getPassword()
        );

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequestDto requestDto, HttpServletRequest request) {

        Member loginedMember = memberService.login(requestDto.getEmail(), requestDto.getPassword());

        HttpSession session = request.getSession();
        session.setAttribute("SESSION_KEY", loginedMember.getId());

        return ResponseEntity.ok().body("정상적으로 로그인 되었습니다.");
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();;  // 세션 무효화
        }
        return ResponseEntity.ok("로그아웃 성공");
    }


    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> findById(@PathVariable Long id) {

        MemberResponseDto memberResponseDto = memberService.findById(id);

        return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }


    // FIXME: 포스트맨 테스트 시 Bad Request(400)가 발생됨 ( 이유 파악 못함 )
    @PatchMapping("/{id}")
    public ResponseEntity<MemberResponseDto> updateMember(
            @PathVariable Long id,
           @Valid @RequestBody UpdateMemberRequestDto requestDto ){

        MemberResponseDto memberResponseDto = memberService.updateMember(id, requestDto.getUsername());

        return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        memberService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}