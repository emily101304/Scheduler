package com.example.scheduler.jdbc.dto;

import lombok.Getter;

@Getter

public class ScheduleResponseDto {

    private Long id;
    private String user;
    private String todo;
    private String initDate;
    private String modDate;

    public ScheduleResponseDto(Long id, String user, String todo, String initDate, String modDate) {
        this.id = id;
        this.user = user;
        this.todo = todo;
        this.initDate = initDate;
        this.modDate = modDate;
    }
}
