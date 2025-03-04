
package ust.com.cicss.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ust.com.cicss.dao.CourseRepository;
import ust.com.cicss.models.GenEdConstraint;
import ust.com.cicss.models.Restrictions;
import ust.com.cicss.services.CourseService;

@RestController
@RequestMapping("/genedconstraint")
public class GenEdConstraintController {

    @Autowired
    private CourseRepository repo;

    @Autowired
    private CourseService service;

    @GetMapping
    public List<GenEdConstraint> getAllGenEdConstraints()
    {
        // SELECT c.course_id, c.name, c.subject_code, restrictions
        // FROM courses c WHERE category = 'gened'
//        return repo.findAll();
        return service.getAllGenEdConstraints();
    }

    //since update din yung delete tinanggal ko nalang yung delete
    @PutMapping("/{course_code}")
    public void updateGenEdConstraint(@RequestBody Restrictions restrictions, @PathVariable String course_code)
    {
        // UPDATE courses SET restrictions = restrictions WHERE course_id = course_id_value
        repo.updateGenEdConstraint((Restrictions) restrictions, course_code);
    }

//    @DeleteMapping("/{course_code}")
//    public void deleteGenEdConstraint(@RequestBody Restrictions restrictions, @PathVariable String course_code)
//    {
//        // UPDATE courses SET restrictions = restrictions WHERE course_id = course_id_value -- bali gagawing empty object pero basta nasa req body na yan
//    }
}
