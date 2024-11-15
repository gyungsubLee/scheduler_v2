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
    @Size(max = 10, message = "일정의 제목은 10글자 이내로 입력해야 합니다.")
    private String title;
    @NotNull
    private String description;
}
