package com.example.scheduler_v2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateScheduleRequestDto {  // Create와 동일하나 나중을 위해 우선 분리함

    private String title;
    private String description;
}
