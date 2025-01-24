package com.example.cicss.controller;

import com.example.cicss.dao.DepartmentChairRepository;
import com.example.cicss.model.DepartmentChair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depchair")
public class DepartmentChairController {
    @Autowired
    private DepartmentChairRepository repo;

    @GetMapping
    public List<DepartmentChair> getAllDepartmentChairs()
    {
        return repo.findAll();
    }

    @PostMapping
    public void addDepartmentChair(@RequestBody DepartmentChair departmentChair)
    {
        repo.save(departmentChair);
    }

    @PutMapping
    public void updateDepartmentChair(@RequestBody DepartmentChair departmentChair)
    {
        repo.save(departmentChair);
    }

    @DeleteMapping
    public void deleteDepartmentChair(@RequestBody DepartmentChair departmentChair)
    {
        repo.delete(departmentChair);
    }
}
