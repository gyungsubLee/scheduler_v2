package com.example.scheduler_v2.dto;

import com.example.scheduler_v2.entity.Schedule;
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

    // 전체 일정 조회 시, 스트림에서 사용되는 Entity -> DTO 변환 메서드
    public static ScheduleResponseDto toDto(Schedule schedule){
        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getDescriptiom(), schedule.getCreatedAt(), schedule.getModifiedAt());
    }
}
