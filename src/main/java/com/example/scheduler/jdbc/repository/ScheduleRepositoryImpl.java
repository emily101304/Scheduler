package com.example.scheduler.jdbc.repository;

import com.example.scheduler.jdbc.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository{

    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Schedule saveSchedule(Schedule schedule) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into schedule(todo) values(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, schedule.getUser());
            ps.setString(2, schedule.getTodo());
            ps.setString(3, schedule.getPassword());
            ps.setString(4, schedule.getInitDate());
            ps.setString(5, schedule.getModDate());
            return ps;
        }, keyHolder);

        schedule.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());

        return schedule;
    }

    @Override
    public Optional<Schedule> findById(Long id) {
        List<Schedule> scheduleList = jdbcTemplate.query(
                "select * from schedule where id = ?",
                (rs, rowNum) -> new Schedule(rs.getLong("id"), rs.getString("todo")),
                id
        );
        return scheduleList.stream().findAny();
    }

    @Override
    public List<Schedule> findAll() {
        return jdbcTemplate.query(
                "select * from schedule",
                (rs, rowNum) ->
                        new Schedule(rs.getLong("id"), rs.getString("todo"))
        );
    }

    @Override
    public Schedule updateTodo(Long id, String todo, String modDate) {
        jdbcTemplate.update(
                "update schedule set todo = ? where id = ?",
                todo,
                id,
                modDate
        );

        return jdbcTemplate.queryForObject(
                "select * from memo where id = ?",
                (rs, rowNum) -> new Schedule(rs.getLong("id"), rs.getString("todo")),
                id
        );
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update(
                "delete from schedule where id = ?",
                id
        );
    }
}
