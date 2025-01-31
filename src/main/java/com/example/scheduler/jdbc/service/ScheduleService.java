package com.example.scheduler.jdbc.service;

import com.example.scheduler.jdbc.dto.ScheduleRequestDto;
import com.example.scheduler.jdbc.dto.ScheduleResponseDto;
import com.example.scheduler.jdbc.entity.Schedule;
import com.example.scheduler.jdbc.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto saveSchedule(ScheduleRequestDto dto) {
        Schedule schedule = new Schedule(dto.getUser(), dto.getTodo(), dto.getPassword());
        Schedule savedSchedule = scheduleRepository.save(schedule);
    }
}
