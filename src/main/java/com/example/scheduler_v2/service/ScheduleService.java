package com.example.scheduler_v2.service;

import com.example.scheduler_v2.dto.ScheduleResponseDto;
import com.example.scheduler_v2.entity.Member;
import com.example.scheduler_v2.entity.Schedule;
import com.example.scheduler_v2.repository.MemberRepository;
import com.example.scheduler_v2.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final MemberRepository memberRepository;

    public ScheduleResponseDto save(Long memberId, String title, String description) {

        Member findMember = memberRepository.findByIdOrElseThrow(memberId);

        Schedule schedule = new Schedule(title, description);
        schedule.setMember(findMember);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getDescriptiom(), schedule.getCreatedAt(), schedule.getModifiedAt());
    }

    public List<ScheduleResponseDto> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }


    public ScheduleResponseDto findById(Long id) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        return new ScheduleResponseDto(findSchedule.getId(), findSchedule.getTitle(), findSchedule.getDescriptiom(), findSchedule.getCreatedAt(), findSchedule.getModifiedAt());
    }

    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, String title, String description) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        findSchedule.update(title, description);  // 변경 감지로 인한 자동 업데이트

        return new ScheduleResponseDto(findSchedule.getId(), findSchedule.getTitle(), findSchedule.getDescriptiom(), findSchedule.getCreatedAt(), findSchedule.getModifiedAt());
    }


    public void delete(Long id) {

        Schedule findSchdule = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(findSchdule);
    }
}
