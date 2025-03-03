
package ust.com.cicss.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ust.com.cicss.dao.TASRepository;
import ust.com.cicss.models.Restrictions;
import ust.com.cicss.models.TAS;
import ust.com.cicss.models.TASConstraint;
import ust.com.cicss.services.TASService;

import java.util.List;

@RestController
@RequestMapping("/tasconstraints")
public class TASConstraintController {

    @Autowired
    private TASRepository repo;

    @Autowired
    private TASService service;

    @GetMapping
    public List<TASConstraint> getAllTASConstraints()
    {
        //return repo.findAll();
        // SELECT tas_id, name, units, courses, restrictions FROM teaching_academic_staff;
        return service.getAllTASConstraints();
    }

    @GetMapping("/{TASConstraintId}")
    public TASConstraint getTASConstraintById(@PathVariable String tasId)
    {
        return service.getTASConstraintById(tasId);
    }

    @PostMapping
    public void addTASConstraint(@Valid @RequestBody TAS tas)
    {
        //repo.save(tasConstraint);
        // mag gegenerate ng unique id na nag sstart with PF like 'PF7ocPtozS'
        // ung units nakadepend kung part time or full time 15 24
        // courses is a text array
        // REQ BODY: {tas_id: 'PF12345678', name: 'Edited Name', units: 24 .. EVERYTHING ELSE DAPAT LAHAT PRESENT paki error ung return if may missing value}
        String randomString = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        String tasId = "PF" + randomString;
        tas.setId(tasId);
        // INSERT INTO teaching_academic_staff (tas_id, units, courses, main_department, restrictions, name, email) VALUES (ung values)
        repo.save(tas);
    }

    @PutMapping("")
    public void updateTASConstraint(@RequestBody Map<String, Object> updates)
    {
        //repo.save(tasConstraint);
        // ang structure ng request body should be tas_id tapos kung ano lng iuupdate like
        // REQ BODY: {tas_id: 'PF12345678', name: 'Edited Name', units: 24} -- name and units lng ung ieedit

        // UPDATE teaching_academic_staff updatecolumn = updatedcolvalue WHERE tas_id = tas_id
        boolean firstEntry = true;
        String tas_id = "";
        String column = "";
        Object value = null;

        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            if (firstEntry) {
                tas_id = entry.getValue().toString(); // First entry is tas_id
                firstEntry = false;
            } else {
                column = entry.getKey(); // Next key as column
                value = entry.getValue(); // Next value
                System.out.println("tas_id: " + tas_id + ", column: " + column + ", value: " + value);

                switch (column) {
                    case "name":
                        repo.updateName(tas_id, (String) value);
                        break;
                    case "units":
                        repo.updateUnits(tas_id, (int) value);
                        break;
                    case "email":
                        repo.updateEmail(tas_id, (String) value);
                        break;
                    case "courses":
                        repo.updateCourses(tas_id, (String[]) value);
                    case "restrictions":
                        repo.updateRestrictions(tas_id, (Restrictions) value);
                    default:
                        throw new IllegalArgumentException("Invalid column name: " + column);
                }
            }
        }
    }

    @DeleteMapping
    public void deleteTASConstraint(@RequestBody Map<String, String> tas_id)
    {
        //repo.delete(tasConstraint);
        // REQ BODY: {tas_id: 'PF12345678'}
        Map.Entry<String, String> entry = tas_id.entrySet().iterator().next();
        String value = entry.getValue();
        // UPDATE teaching_academic_staff is_active = 1 WHERE tas_id = tas_id
        repo.deleteById(value);
    }
}