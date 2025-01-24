package com.example.cicss.controller;

import com.example.cicss.model.Course;
import com.example.cicss.dao.CourseRepository;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@Table(name = "courses")
public class CourseController {

    @Autowired
    private CourseRepository repo;

    @GetMapping
    public List<Course> getCourses()
    {
        return repo.findAll();
    }

    @GetMapping("/{courseCode}")
    public Course getCourse(@PathVariable String courseCode) {
        return repo.findById(courseCode).orElse(null);
    }

    @PostMapping
    public void addCourse(@RequestBody Course course)
    {
        repo.save(course);
    }

    @PutMapping
    public void updateCourse(@RequestBody Course course)
    {
        repo.save(course);
    }

    @DeleteMapping
    public void deleteCourse(@PathVariable String courseId)
    {
        repo.deleteById(courseId);
    }
}
