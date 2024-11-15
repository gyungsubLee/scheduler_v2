package com.example.scheduler_v2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class CreateScheduleRequestDto {

    @NotBlank
    private Long memberId;
    @NotBlank
    private String title;
    @NotNull
    private String description;
}
