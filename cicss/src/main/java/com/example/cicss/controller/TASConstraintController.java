package com.example.cicss.controller;

import com.example.cicss.dao.TASConstraintRepository;
import com.example.cicss.model.TASConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasconstraints")
public class TASConstraintController {

    @Autowired
    private TASConstraintRepository repo;

    @GetMapping
    public List<TASConstraint> getAllTASConstraints()
    {
        return repo.findAll();
    }

    @GetMapping("/{TASConstraintId}")
    public TASConstraint getTASConstraintById(@PathVariable String TASConstraintId)
    {
        return repo.findById(TASConstraintId).orElse(null);
    }

    @PostMapping
    public void addTASConstraint(@RequestBody TASConstraint tasConstraint)
    {
        repo.save(tasConstraint);
    }

    @PutMapping
    public void updateTASConstraint(@RequestBody TASConstraint tasConstraint)
    {
        repo.save(tasConstraint);
    }

    @DeleteMapping
    public void deleteTASConstraint(@RequestBody TASConstraint tasConstraint)
    {
        repo.delete(tasConstraint);
    }
}
