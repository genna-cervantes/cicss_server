package com.example.cicss.controller;

import com.example.cicss.dao.SectionCountRepository;
import com.example.cicss.model.SectionCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sectioncount")
public class SectionCountController {

    @Autowired
    private SectionCountRepository repo;

    @GetMapping("/{department}")
    public List<SectionCount> getAllSectionCountsByDepartment(@PathVariable String department)
    {
        return repo.getAllSectionCountsByDepartment(department);
    }

    @PostMapping
    public void addSectionCounts(@RequestBody SectionCount sectionCount)
    {
        repo.save(sectionCount);
    }

    @PutMapping
    public void updateSectionCounts(@RequestBody SectionCount sectionCount)
    {
        repo.save(sectionCount);
    }
}
