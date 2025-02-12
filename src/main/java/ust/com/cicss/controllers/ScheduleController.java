package ust.com.cicss.controllers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ust.com.cicss.dao.ScheduleRepository;
import ust.com.cicss.models.Schedule;
import ust.com.cicss.services.ScheduleService;

import java.util.Map;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleRepository repo;

    @Autowired
    private ScheduleService service;

    @GetMapping("/{schedule_id}")
    public Map<String, Object> getScheduleById(@PathVariable String schedule_id)
    {
        return service.getSchedule(schedule_id);
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

    @PutMapping("/cs/lock/{schedule_id}")
    public int updateCSLocked(@PathVariable String schedule_id, boolean csLocked)
    {
        System.out.println(csLocked);
        return service.updateCSLocked(schedule_id, csLocked);
    }

    @PutMapping("/cs/ready/{schedule_id}")
    public int updateCSReady(@PathVariable String schedule_id, boolean csReady)
    {
        return service.updateCSReady(schedule_id, csReady);
    }

    @PutMapping("/cs/deploy/{schedule_id}")
    public int updateCSDeploy(@PathVariable String schedule_id, boolean csReady)
    {
        return service.updateCSDeploy(schedule_id, csReady);
    }

    @PutMapping("/it/locked/{schedule_id}")
    public int updateITLocked(@PathVariable String schedule_id, boolean itLocked)
    {
        return service.updateITLocked(schedule_id, itLocked);
    }

    @PutMapping("/it/ready/{schedule_id}")
    public int updateITReady(@PathVariable String schedule_id, boolean itReady)
    {
        return service.updateITReady(schedule_id, itReady);
    }

    @PutMapping("/it/deploy/{schedule_id}")
    public int updateITDeploy(@PathVariable String schedule_id, boolean itDeploy)
    {
        return service.updateITDeploy(schedule_id, itDeploy);
    }

    @PutMapping("/is/locked/{schedule_id}")
    public int updateISLocked(@PathVariable String schedule_id, boolean isLocked)
    {
        return service.updateISLocked(schedule_id, isLocked);
    }

    @PutMapping("/is/ready/{schedule_id}")
    public int updateISReady(@PathVariable String schedule_id, boolean isReady)
    {
        return service.updateISReady(schedule_id, isReady);
    }

    @PutMapping("/is/deploy/{schedule_id}")
    public int updateISDeploy(@PathVariable String schedule_id, boolean isDeploy)
    {
        return service.updateISDeploy(schedule_id, isDeploy);
    }
}
