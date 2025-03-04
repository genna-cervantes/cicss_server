package ust.com.cicss.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ust.com.cicss.dao.CourseRepository;
import ust.com.cicss.models.Course;
import ust.com.cicss.models.GenEdConstraint;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repo;

    public List<GenEdConstraint> getAllGenEdConstraints() {
        List<Course> allGenEdCourses = repo.getAllGenEdCourses();
        List<GenEdConstraint> allGenEdConstraints = new ArrayList<>();

        for(Course c: allGenEdCourses) {
            GenEdConstraint gec = new GenEdConstraint(
                    c.getSubjectCode(),
                    c.getCourseName(),
                    c.getRestrictions()
            );
            allGenEdConstraints.add(gec);
        }

        return allGenEdConstraints;
    }
}
