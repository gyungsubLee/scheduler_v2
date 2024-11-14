package com.example.scheduler_v2.service;

import com.example.scheduler_v2.dto.ScheduleResponseDto;
import com.example.scheduler_v2.entity.Schedule;
import com.example.scheduler_v2.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto save(String title, String description) {

        Schedule schedule = new Schedule(title, description);
        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getDescriptiom(), schedule.getCreatedAt(), schedule.getModifiedAt());
    }
}
