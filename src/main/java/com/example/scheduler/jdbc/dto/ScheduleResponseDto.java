package com.example.scheduler.jdbc.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter

public class ScheduleResponseDto {

    private Long id;
    private String user;
    private String todo;
    private LocalDateTime initDate;
    private LocalDateTime modDate;

    public ScheduleResponseDto(Long id, String user, String todo, LocalDateTime initDate, LocalDateTime modDate) {
        this.id = id;
        this.user = user;
        this.todo = todo;
        this.initDate = initDate;
        this.modDate = modDate;
    }

    public ScheduleResponseDto(Long id, String user, String todo) {
        this.id = id;
        this.user = user;
        this.todo = todo;
    }
}
