package com.example.scheduler_v2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class MemberResponseDto {

    private String username;
    private String email;

    public MemberResponseDto(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
