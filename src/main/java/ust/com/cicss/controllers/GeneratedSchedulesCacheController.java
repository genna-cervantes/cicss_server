package ust.com.cicss.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ust.com.cicss.dao.GeneratedSchedulesCacheRepository;

import java.util.Map;

@RestController
@RequestMapping("/schedcache")
public class GeneratedSchedulesCacheController {
    @Autowired
    private GeneratedSchedulesCacheRepository repo;

    @GetMapping
    public String getCachedSchedule()
    {
        return repo.getCachedSchedule();
    }
}
