package com.example.scheduler_v2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateScheduleRequestDto {
    private String title;
    private String description;
}
