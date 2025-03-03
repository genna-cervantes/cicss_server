
package ust.com.cicss.controllers;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            String restrictionsJson = objectMapper.writeValueAsString(restrictions); // Convert to JSON String
//            System.out.println("Generated JSON: " + restrictionsJson);
//            repo.updateGenEdConstraint(restrictionsJson, course_code);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException("Error converting restrictions to JSON", e);
//        }
        repo.updateGenEdConstraint((Restrictions) restrictions, course_code);
    }
    public void addGenEdConstraint(@RequestBody Restrictions restrictions, @PathVariable String course_code)
    {
        // UPDATE courses SET restrictions = restrictions WHERE course_id = course_id_value
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String restrictionsJson = objectMapper.writeValueAsString(restrictions); // Convert to JSON String
            System.out.println("Generated JSON: " + restrictionsJson);
            repo.updateGenEdConstraint(restrictionsJson, course_code);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting restrictions to JSON", e);
        }
    }
//    @PutMapping
//    public void updateGenEdConstraint(@RequestBody GenEdConstraint genEdConstraint)
//    {
//        // UPDATE courses SET restrictions = restrictions WHERE course_id = course_id_value
//        //repo.save(genEdConstraint);
//    }

//    @DeleteMapping("/{course_code}")
//    public void deleteGenEdConstraint(@RequestBody Restrictions restrictions, @PathVariable String course_code)
//    {
//        // UPDATE courses SET restrictions = restrictions WHERE course_id = course_id_value -- bali gagawing empty object pero basta nasa req body na yan
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            String restrictionsJson = objectMapper.writeValueAsString(restrictions); // Convert to JSON String
//            System.out.println("Generated JSON: " + restrictionsJson);
//            repo.updateGenEdConstraint(restrictionsJson, course_code);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException("Error converting restrictions to JSON", e);
//        }
//    }
}
