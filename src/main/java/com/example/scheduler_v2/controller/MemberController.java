package com.example.scheduler_v2.controller;


import com.example.scheduler_v2.dto.ScheduleResponseDto;
import com.example.scheduler_v2.dto.SignUpRequestDto;
import com.example.scheduler_v2.dto.SignUpResponseDto;
import com.example.scheduler_v2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto){

        SignUpResponseDto signUpResponseDto = memberService.signUp(
                requestDto.getUsername(),
                requestDto.getEmail(),
                requestDto.getPassword()
        );

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);

    }

}