package com.example.scheduler_v2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class UpdateMemberRequestDto {

    private String username;

    public UpdateMemberRequestDto(String username) {
        this.username = username;
    }
}
