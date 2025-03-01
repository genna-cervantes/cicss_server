package ust.com.cicss.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ust.com.cicss.dao.CourseOfferingsRepository;
import ust.com.cicss.models.CourseOfferings;

@RestController
@RequestMapping("/courseofferings")
public class CourseOfferingsController {

    @Autowired
    private CourseOfferingsRepository repo;

    @GetMapping
    public List<CourseOfferings> getCourseOfferings() {
        // SELECT c.course_id, c.name, c.subject_code, c.total_units, c.type
        // FROM courses c
        // JOIN curriculum cur ON c.course_id = ANY(cur.courses)
        // WHERE cur.year = $1 AND cur.semester = $2 AND cur.department = $3;
        return repo.findAll();
    }

    @PostMapping
    public void addCourseOfferings(@RequestBody CourseOfferings courseOfferings) {
        // 2 ung queries na need gawin nito
        // generate course id CR + random string of length 8 so 'CRRwSJc1Ec'

        // INSERT INTO courses (course_id, subject_code, units_per_class, type, category, restrictions, total_units, specific_room_assignment) VALUES (...ung values) -- nasa req body toh dapat lahat
        // UPDATE curriculum
        // SET courses = ARRAY_APPEND(courses, $4)
        // WHERE year = $1 AND semester = $2 AND department = $3;
        repo.save(courseOfferings);
    }

    @PutMapping
    public void updateCourseOfferings(@RequestBody CourseOfferings courseOfferings) {
        // UPDATE courses SET updatecolumn = updatedcolvalue WHERE course_id = course_id_value
        repo.save(courseOfferings);
    }
}
