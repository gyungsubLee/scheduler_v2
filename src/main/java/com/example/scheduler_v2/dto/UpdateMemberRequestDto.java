package com.example.scheduler_v2.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class UpdateMemberRequestDto {

    @NotBlank
    @Size(max = 4, message = "이름은 4글자 이내로 입력해 주세요")
    private String username;

    public UpdateMemberRequestDto(String username) {
        this.username = username;
    }
}
