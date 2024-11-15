package com.example.scheduler_v2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateScheduleRequestDto {  // Create와 동일하나 나중을 위해 우선 분리함

    @NotBlank
    @Size(max = 10)
    private String title;
    @NotNull
    private String description;
}
