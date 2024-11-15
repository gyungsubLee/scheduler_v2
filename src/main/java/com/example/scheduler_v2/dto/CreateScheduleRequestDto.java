package com.example.scheduler_v2.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class CreateScheduleRequestDto {

    @NotBlank
    private Long memberId;
    @NotBlank
    @Size(max = 10)
    private String title;
    @NotNull
    private String description;
}
