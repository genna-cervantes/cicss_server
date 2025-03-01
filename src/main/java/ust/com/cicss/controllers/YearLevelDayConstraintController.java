
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

import ust.com.cicss.dao.YearLevelDayConstraintRepository;
import ust.com.cicss.models.YearLevelDayConstraint;

@RestController
@RequestMapping("/yldconstraint")
public class YearLevelDayConstraintController {
    @Autowired
    private YearLevelDayConstraintRepository repo;

    @GetMapping
    public List<YearLevelDayConstraint> getAllYearLevelDayConstraints()
    {
        // SELECT year_day_restriction_id, available_days, max_days WHERE year = $1 AND department = $2
        return repo.findAll();
    }

    @PostMapping
    public void addYearLevelDayConstraint(@RequestBody YearLevelDayConstraint yearLevelDayConstraint)
    {
        // gawa ng custom id for 'YD' + 8 length string random
        // INSERT INTO year_day_restrictions (year_day_restriction_id, available_days, max_days, year, department) VALUES ()
        repo.save(yearLevelDayConstraint);
    }

    @PutMapping
    public void updateYearLevelDayConstraint(@RequestBody YearLevelDayConstraint yearLevelDayConstraint)
    {
        // UPDATE year_day_restrictions SET updatecolumn = updatedcolvalue WHERE year_day_restriction_id = year_day_restriction_id
        repo.save(yearLevelDayConstraint);
    }

    @DeleteMapping
    public void deleteYearLevelDayConstraint(@RequestBody YearLevelDayConstraint yearLevelDayConstraint)
    {
        // UPDATE year_day_restrictions SET is_active = 0 WHERE year_day_restriction_id = year_day_restriction_id
        repo.delete(yearLevelDayConstraint);
    }
}
