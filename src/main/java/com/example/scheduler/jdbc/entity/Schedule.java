package com.example.scheduler.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Schedule {

    @Setter
    private Long id;
    private String user;
    private String todo;
    private String password;
    private LocalDateTime initDate;
    private LocalDateTime modDate;

    public Schedule(String user, String todo, String password, LocalDateTime initDate, LocalDateTime modDate) {
        this.user = user;
        this.todo = todo;
        this.password = password;
        this.initDate = initDate;
        this.modDate = modDate;
    }
    public Schedule(String user, String password, String todo) {
        this.user = user;
        this.password = password;
        this.todo = todo;
    }

    public Schedule(long id, String todo) {
        this.id = id;
        this.todo = todo;
    }
}
