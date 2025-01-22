package com.example.cicss.controller;

import com.example.cicss.dao.GenEdConstraintRepository;
import com.example.cicss.model.GenEdConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genedconstraint")
public class GenEdConstraintController {

    @Autowired
    private GenEdConstraintRepository repo;

    @GetMapping
    public List<GenEdConstraint> getAllGenEdConstraints()
    {
        return repo.findAll();
    }

    @PostMapping
    public void addGenEdConstraint(@RequestBody GenEdConstraint genEdConstraint)
    {
        repo.save(genEdConstraint);
    }

    @PutMapping
    public void updateGenEdConstraint(@RequestBody GenEdConstraint genEdConstraint)
    {
        repo.save(genEdConstraint);
    }

    @DeleteMapping
    public void deleteGenEdConstraint(@RequestBody GenEdConstraint genEdConstraint)
    {
        repo.delete(genEdConstraint);
    }
}
