package ust.com.cicss.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ust.com.cicss.dao.GenEdConstraintRepository;
import ust.com.cicss.models.GenEdConstraint;

@RestController
@RequestMapping("/genedconstraint")
public class GenEdConstraintController {

    @Autowired
    private GenEdConstraintRepository repo;

    @GetMapping
    public List<GenEdConstraint> getAllGenEdConstraints()
    {
        // SELECT c.course_id, c.name, c.subject_code, restrictions
        // FROM courses c WHERE category = 'gened'
        return repo.findAll();
    }

    @PostMapping
    public void addGenEdConstraint(@RequestBody GenEdConstraint genEdConstraint)
    {
        // UPDATE courses SET restrictions = restrictions WHERE course_id = course_id_value
        repo.save(genEdConstraint);
    }
    
    @PutMapping
    public void updateGenEdConstraint(@RequestBody GenEdConstraint genEdConstraint)
    {
        // UPDATE courses SET restrictions = restrictions WHERE course_id = course_id_value
        repo.save(genEdConstraint);
    }
    
    @DeleteMapping
    public void deleteGenEdConstraint(@RequestBody GenEdConstraint genEdConstraint)
    {
        // UPDATE courses SET restrictions = restrictions WHERE course_id = course_id_value -- bali gagawing empty object pero basta nasa req body na yan
        repo.delete(genEdConstraint);
    }
}
