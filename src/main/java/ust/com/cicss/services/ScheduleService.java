package ust.com.cicss.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ust.com.cicss.dao.ScheduleRepository;
import ust.com.cicss.models.Schedule;

import java.util.Map;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository repo;

    public Map<String, Object> getSchedule(String scheduleId)
    {
        return repo.findById(scheduleId)
                .map(Schedule::getSchedule)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
    }

    public int updateCSLocked(String scheduleId, boolean value)
    {
       return repo.updateCSLocked(scheduleId, value);
    }

    public int updateCSReady(String scheduleId, boolean value)
    {
        return repo.updateCSReady(scheduleId, value);
    }

    public int updateCSDeploy(String scheduleId, boolean value)
    {
        return repo.updateCSDeploy(scheduleId, value);
    }

    public int updateITLocked(String scheduleId, boolean value)
    {
        return repo.updateITLocked(scheduleId, value);
    }

    public int updateITReady(String scheduleId, boolean value)
    {
        return repo.updateITReady(scheduleId, value);
    }

    public int updateITDeploy(String scheduleId, boolean value)
    {
        return repo.updateITDeploy(scheduleId, value);
    }

    public int updateISLocked(String scheduleId, boolean value)
    {
        return repo.updateISLocked(scheduleId, value);
    }

    public int updateISReady(String scheduleId, boolean value)
    {
        return repo.updateISReady(scheduleId, value);
    }

    public int updateISDeploy(String scheduleId, boolean value)
    {
        return repo.updateISDeploy(scheduleId, value);
    }
}
