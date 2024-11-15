package com.example.scheduler_v2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpResponseDto {

    private Long id;
    private String username;
    private String email;
}
