package com.example.scheduler.jdbc.service;

import com.example.scheduler.jdbc.dto.ScheduleRequestDto;
import com.example.scheduler.jdbc.dto.ScheduleResponseDto;
import com.example.scheduler.jdbc.entity.Schedule;
import com.example.scheduler.jdbc.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto dto) {
        Schedule schedule = new Schedule(dto.getUser(), dto.getTodo(), dto.getPassword());
        Schedule savedSchedule = scheduleRepository.saveSchedule(schedule);
        return new ScheduleResponseDto(
                savedSchedule.getId(),
                savedSchedule.getUser(),
                savedSchedule.getTodo(),
                savedSchedule.getInitDate(),
                savedSchedule.getModDate()
        );
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> getSchedules() {
        List<Schedule> scheduleList = scheduleRepository.findAll();

        List<ScheduleResponseDto> dtoList = new ArrayList<>();
        for (Schedule schedule : scheduleList) {
            ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(
                    schedule.getId(),
                    schedule.getUser(),
                    schedule.getTodo(),
                    schedule.getInitDate(),
                    schedule.getModDate()
            );
            dtoList.add(scheduleResponseDto);
        }
        return dtoList;
    }

    @Transactional(readOnly = true)
    public ScheduleResponseDto getSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("해당하는 일정이 없습니다.")
        );
        return new ScheduleResponseDto(schedule.getId(), schedule.getTodo(),schedule.getUser(),schedule.getInitDate(),schedule.getModDate());
    }

    @Transactional
    public ScheduleResponseDto updateSchedule(Long scheduleId, ScheduleRequestDto dto) {
        Schedule schedule = scheduleRepository.updateTodo(scheduleId,dto.getTodo(),dto.getUser());
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getUser(),
                schedule.getTodo()
        );
    }

    @Transactional
    public void deleteScheduleById(Long scheduleId) {
        scheduleRepository.deleteById(scheduleId);
    }
}
