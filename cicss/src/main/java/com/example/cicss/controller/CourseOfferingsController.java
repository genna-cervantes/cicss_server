package com.example.cicss.controller;

import com.example.cicss.dao.CourseOfferingsRepository;
import com.example.cicss.model.CourseOfferings;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courseofferings")
public class CourseOfferingsController {

    @Autowired
    private CourseOfferingsRepository repo;

    @GetMapping
    public List<CourseOfferings> getCourseOfferings()
    {
        return repo.findAll();
    }

    @PostMapping
    public void addCourseOfferings(@RequestBody CourseOfferings courseOfferings)
    {
        repo.save(courseOfferings);
    }

    @PutMapping
    public void updateCourseOfferings(@RequestBody CourseOfferings courseOfferings)
    {
        repo.save(courseOfferings);
    }
}
