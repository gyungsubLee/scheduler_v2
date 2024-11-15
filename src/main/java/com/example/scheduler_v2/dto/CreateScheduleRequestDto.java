package com.example.scheduler_v2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateScheduleRequestDto {
    private Long memberId;
    private String title;
    private String description;
}
