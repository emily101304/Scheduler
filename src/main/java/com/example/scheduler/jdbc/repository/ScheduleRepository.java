package com.example.scheduler.jdbc.repository;

import com.example.scheduler.jdbc.entity.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {

    Schedule saveSchedule(Schedule schedule);
    Optional<Schedule> findById(Long id);
    List<Schedule> findAll();
    Schedule updateTodo(Long id, String todo, String modDate);
    void deleteById(Long id);
}
