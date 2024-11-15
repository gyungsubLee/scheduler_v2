package com.example.scheduler_v2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class UpdateScheduleRequestDto {  // Create와 동일하나 나중을 위해 우선 분리함

    @NotBlank
    @Size(max = 10, message = "일정의 제목은 10글자 이내로 입력해야 합니다.")
    private String title;
    @NotNull
    private String description;

    public UpdateScheduleRequestDto(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
