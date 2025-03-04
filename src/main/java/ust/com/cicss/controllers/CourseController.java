package ust.com.cicss.controllers;

import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ust.com.cicss.dao.CourseRepository;
import ust.com.cicss.models.Course;

import java.util.List;
import java.util.UUID;

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
        String randomString = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        String courseId = "CR" + randomString;
        course.setCourseId(courseId);
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
