package ust.com.cicss.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ust.com.cicss.dao.YearLevelDayConstraintRepository;
import ust.com.cicss.models.YearLevelDayConstraint;

import java.util.List;

@RestController
@RequestMapping("/yldconstraint")
public class YearLevelDayConstraintController {
    @Autowired
    private YearLevelDayConstraintRepository repo;

    @GetMapping
    public List<YearLevelDayConstraint> getAllYearLevelDayConstraints()
    {
        return repo.findAll();
    }

    @PostMapping
    public void addYearLevelDayConstraint(@RequestBody YearLevelDayConstraint yearLevelDayConstraint)
    {
        repo.save(yearLevelDayConstraint);
    }

    @PutMapping
    public void updateYearLevelDayConstraint(@RequestBody YearLevelDayConstraint yearLevelDayConstraint)
    {
        repo.save(yearLevelDayConstraint);
    }

    @DeleteMapping
    public void deleteYearLevelDayConstraint(@RequestBody YearLevelDayConstraint yearLevelDayConstraint)
    {
        repo.delete(yearLevelDayConstraint);
    }
}
