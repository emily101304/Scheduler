package com.example.scheduler.jdbc.controller;

import com.example.scheduler.jdbc.dto.ScheduleRequestDto;
import com.example.scheduler.jdbc.dto.ScheduleResponseDto;
import com.example.scheduler.jdbc.entity.Schedule;
import com.example.scheduler.jdbc.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> savedSchedule(@RequestBody ScheduleRequestDto dto) {
        return ResponseEntity.ok(scheduleService.saveSchedule(dto));
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleResponseDto>> getSchedules() {
        return ResponseEntity.ok(scheduleService.getSchedules());
    }

    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto> getSchedule(@PathVariable Long scheduleId) {
        return ResponseEntity.ok(scheduleService.getSchedule(scheduleId));
    }

    @PatchMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long scheduleId, @RequestBody ScheduleRequestDto dto) {
        return ResponseEntity.ok(scheduleService.updateSchedule(scheduleId,dto));
    }

    @DeleteMapping("/schedules/{scheduleId}")
    public void deleteSchedule(@PathVariable Long scheduleId) {
        scheduleService.deleteScheduleById(scheduleId);
    }

}
