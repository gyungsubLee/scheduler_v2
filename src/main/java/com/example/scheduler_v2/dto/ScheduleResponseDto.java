package com.example.scheduler_v2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long id;
    private String title;
    private String descriptiom;
    private LocalDateTime createdAt;   // 생성 날짜
    private LocalDateTime modifiedAt;  // 수정 날짜
}
