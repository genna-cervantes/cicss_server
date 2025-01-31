package ust.com.cicss.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ust.com.cicss.dao.ScheduleRepository;
import ust.com.cicss.models.schedule.Schedule;
import ust.com.cicss.models.schedule.SectionSchedule;

import java.util.Map;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleRepository repo;

    @GetMapping("/{schedule_id}")
    public Schedule getScheduleById(@PathVariable String schedule_id)
    {
        return repo.findById(schedule_id).orElseThrow();
    }

    @PostMapping
    public void addSchedule(@RequestBody Schedule schedule)
    {
        repo.save(schedule);
    }

    @PutMapping
    public void updateSchedule(@RequestBody Schedule schedule)
    {
        repo.save(schedule);
    }

//    @PutMapping
//    public void updateCSReady(boolean csReady)
//    {
//
//    }
}
