package com.example.cicss.controller;

import com.example.cicss.dao.YearLevelTimeConstraintRepository;
import com.example.cicss.model.YearLevelTimeConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/yltconstraints")
public class YearLevelTimeConstraintController {
    @Autowired
    private YearLevelTimeConstraintRepository repo;

    @GetMapping
    public List<YearLevelTimeConstraint> getAllYearLevelTimeConstraints()
    {
        return repo.findAll();
    }

    @PostMapping
    public void addYearLevelTimeConstraint(@RequestBody YearLevelTimeConstraint yearLevelTimeConstraint)
    {
        repo.save(yearLevelTimeConstraint);
    }

    @PutMapping
    public void updateYearLevelTimeConstraint(@RequestBody YearLevelTimeConstraint yearLevelTimeConstraint)
    {
        repo.save(yearLevelTimeConstraint);
    }

    @DeleteMapping
    public void deleteYearLevelTimeConstraint(@RequestBody YearLevelTimeConstraint yearLevelTimeConstraint)
    {
        repo.delete(yearLevelTimeConstraint);
    }
}
