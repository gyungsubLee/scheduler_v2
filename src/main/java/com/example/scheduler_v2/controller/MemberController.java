package com.example.scheduler_v2.controller;


import com.example.scheduler_v2.dto.*;
import com.example.scheduler_v2.service.MemberService;
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
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequestDto requestDto) {

        memberService.login(requestDto.getEmail(), requestDto.getPassword());

        return ResponseEntity.ok().body("정상적으로 로그인 되었습니다.");
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