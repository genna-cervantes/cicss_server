package ust.com.cicss.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ust.com.cicss.dao.TASConstraintRepository;
import ust.com.cicss.models.TASConstraint;

@RestController
@RequestMapping("/tasconstraints")
public class TASConstraintController {

    @Autowired
    private TASConstraintRepository repo;

    @GetMapping
    public List<TASConstraint> getAllTASConstraints()
    {
        // SELECT tas_id, name, units, courses, restrictions FROM teaching_academic_staff;
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
        // mag gegenerate ng unique id na nag sstart with PF like 'PF7ocPtozS'
        // ung units nakadepend kung part time or full time 15 24
        // courses is a text array
        // REQ BODY: {tas_id: 'PF12345678', name: 'Edited Name', units: 24 .. EVERYTHING ELSE DAPAT LAHAT PRESENT paki error ung return if may missing value} 

        // INSERT INTO teaching_academic_staff (tas_id, units, courses, main_department, restrictions, name, email) VALUES (ung values)
        repo.save(tasConstraint);
    }

    @PutMapping
    public void updateTASConstraint(@RequestBody TASConstraint tasConstraint)
    {
        // ang structure ng request body should be tas_id tapos kung ano lng iuupdate like
        // REQ BODY: {tas_id: 'PF12345678', name: 'Edited Name', units: 24} -- name and units lng ung ieedit
        
        // UPDATE teaching_academic_staff updatecolumn = updatedcolvalue WHERE tas_id = tas_id
        repo.save(tasConstraint);
    }
    
    @DeleteMapping
    public void deleteTASConstraint(@RequestBody TASConstraint tasConstraint)
    {
        // REQ BODY: {tas_id: 'PF12345678'}

        // UPDATE teaching_academic_staff is_active = 1 WHERE tas_id = tas_id
        repo.delete(tasConstraint);
    }
}
