
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

import ust.com.cicss.dao.YearLevelTimeConstraintRepository;
import ust.com.cicss.models.YearLevelTimeConstraint;

@RestController
@RequestMapping("/yltconstraints")
public class YearLevelTimeConstraintController {
    @Autowired
    private YearLevelTimeConstraintRepository repo;

    @GetMapping
    public List<YearLevelTimeConstraint> getAllYearLevelTimeConstraints()
    {
        // SELECT year_time_restriction_id, restricitons WHERE year = $1 AND department = $2
        return repo.findAll();
    }

    @PostMapping
    public void addYearLevelTimeConstraint(@RequestBody YearLevelTimeConstraint yearLevelTimeConstraint)
    {
        // gawa ng custom id for 'YT' + 8 length string random
        // INSERT INTO year_day_restrictions (year_time_restriction_id, restrictions, year, department) VALUES ()
        repo.save(yearLevelTimeConstraint);
    }

    @PutMapping
    public void updateYearLevelTimeConstraint(@RequestBody YearLevelTimeConstraint yearLevelTimeConstraint)
    {
        // UPDATE year_time_restrictions SET updatecolumn = updatedcolvalue WHERE year_time_restriction_id = year_time_restriction_id
        repo.save(yearLevelTimeConstraint);
    }

    @DeleteMapping
    public void deleteYearLevelTimeConstraint(@RequestBody YearLevelTimeConstraint yearLevelTimeConstraint)
    {
        // UPDATE year_time_restrictions SET is_active = 0 WHERE year_time_restriction_id = year_time_restriction_id
        repo.delete(yearLevelTimeConstraint);
    }
}