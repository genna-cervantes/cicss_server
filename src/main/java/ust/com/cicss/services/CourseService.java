package ust.com.cicss.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ust.com.cicss.dao.CourseRepository;
import ust.com.cicss.models.Course;
import ust.com.cicss.models.GenEdConstraint;
import ust.com.cicss.models.TAS;
import ust.com.cicss.models.TASConstraint;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repo;

    public List<GenEdConstraint> getAllGenEdConstraints() {
        // List<GenEdConstraint> allGenEdConstraints = repo.getAllGenEdCourseConstraints();

        // for (GenEdConstraint genedConstraint: allGenEdConstraints){
        //     System.out.println(genedConstraint);
        // }

        // return allGenEdConstraints;

        List<String> genedCourseIds = repo.getAllGendCourseIds();
        List<GenEdConstraint> genedConstraints = new ArrayList<>();

        for(String genedCourseId: genedCourseIds) {
            Course genedCourse = repo.findById(genedCourseId)
                    .orElseThrow(() -> new NoSuchElementException("TAS not found with ID: " + genedCourseId));
            GenEdConstraint genedConstraint = new GenEdConstraint(
                    genedCourse.getSubjectCode(),
                    genedCourse.getCourseName(),
                    genedCourse.getRestrictions()
            );
            // System.out.println("tas constraints");
            // System.out.println(tas.getRestrictions());
            genedConstraints.add(genedConstraint);
        }
        return genedConstraints;
    }
}
