package ust.com.cicss.controllers;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;
import ust.com.cicss.dao.TASRepository;
import ust.com.cicss.models.Restrictions;
import ust.com.cicss.models.TAS;
import ust.com.cicss.models.TASConstraint;
import ust.com.cicss.services.TASService;

@RestController
@RequestMapping("/tasconstraints")
public class TASConstraintController {

    @Autowired
    private TASRepository repo;

    @Autowired
    private TASService service;

    @PreAuthorize("hasAuthority('ROLE_Department_Chair')")
    @GetMapping
    public List<TASConstraint> getAllTASConstraints() {
        //return repo.findAll();
        // SELECT tas_id, name, units, courses, restrictions FROM teaching_academic_staff;
        return service.getAllTASConstraints();
    }

    @PreAuthorize("hasAuthority('ROLE_Department_Chair')")
    @GetMapping("/{mainDepartment}")
    public List<TASConstraint> getAllTASConstraintsByDepartment(@PathVariable String mainDepartment) {
        return service.getAllTASConstraintsByDepartment(mainDepartment);
    }

    @PreAuthorize("hasAuthority('ROLE_Department_Chair') or hasAuthority('ROLE_Student') or hasAuthority('ROLE_TAS')")
    @GetMapping("/details/{mainDepartment}")
    public List<Map<String, String>> getAllTASDetailsByDepartment(@PathVariable String mainDepartment){
        return service.getAllDetailsByDepartment(mainDepartment);
    }

    // no use case
    // @GetMapping("/{TASConstraintId}")
    // public TASConstraint getTASConstraintById(@PathVariable String tasId) {
    //     return service.getTASConstraintById(tasId);
    // }

    @PreAuthorize("hasAuthority('ROLE_Department_Chair')")
    @PostMapping
    public void addTASConstraint(@Valid @RequestBody TAS tas) {
        //repo.save(tasConstraint);
        // mag gegenerate ng unique id na nag sstart with PF like 'PF7ocPtozS'
        // ung units nakadepend kung part time or full time 15 24
        // courses is a text array
        // REQ BODY: {tas_id: 'PF12345678', name: 'Edited Name', units: 24 .. EVERYTHING ELSE DAPAT LAHAT PRESENT paki error ung return if may missing value}
        System.out.println(tas);

        String randomString = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        String tasId = "PF" + randomString;
        tas.setId(tasId);
        // INSERT INTO teaching_academic_staff (tas_id, units, courses, main_department, restrictions, name, email) VALUES (ung values)
        repo.save(tas);
    }

    @PreAuthorize("hasAuthority('ROLE_Department_Chair')")
    @PutMapping
    public void updateTASConstraint(@RequestBody Map<String, Object> updates) {
        //repo.save(tasConstraint);
        // ang structure ng request body should be tas_id tapos kung ano lng iuupdate like
        // REQ BODY: {tas_id: 'PF12345678', name: 'Edited Name', units: 24} -- name and units lng ung ieedit

        if (updates.get("tasId") == null) {
            throw new IllegalArgumentException("Missing tasId for update");
        }

        // UPDATE teaching_academic_staff updatecolumn = updatedcolvalue WHERE tas_id = tas_id
        String tas_id = String.valueOf(updates.get("tasId"));
        ObjectMapper mapper = new ObjectMapper();
        String column = "";
        Object value = null;

        for (Map.Entry<String, Object> entry : updates.entrySet()) {

            if (entry.getKey().equals("tasId")) {
                continue;
            }

            column = entry.getKey(); // Next key as column
            value = entry.getValue(); // Next value
            System.out.println("tas_id: " + tas_id + ", column: " + column + ", value: " + value);

            switch (column) {
                case "name":
                    repo.updateName(tas_id, (String) value);
                    break;
                case "units":
                    repo.updateUnits(tas_id, Integer.parseInt(String.valueOf(value)));
                    break;
                case "email":
                    repo.updateEmail(tas_id, (String) value);
                    break;
                case "courses":
                    String[] courses = mapper.convertValue(value, String[].class);
                    repo.updateCourses(tas_id, courses);
                    break;
                case "restrictions":
                    Restrictions restrictions = mapper.convertValue(value, Restrictions.class);
                    repo.updateRestrictions(tas_id, restrictions);
                    break;
                case "is_active":
                    repo.updateIsActive(tas_id, (Boolean) value);
                default:
                    throw new IllegalArgumentException("Invalid column name: " + column);
            }

        }
    }

    @PreAuthorize("hasAuthority('ROLE_Department_Chair')")
    @DeleteMapping
    public void deleteTASConstraint(@RequestBody Map<String, String> tas_id) {
        //repo.delete(tasConstraint);
        // REQ BODY: {tas_id: 'PF12345678'}
        if (tas_id == null || tas_id.isEmpty()) {
            throw new IllegalArgumentException("Missing tasId for delete");
        }

        Map.Entry<String, String> entry = tas_id.entrySet().iterator().next();
        String value = entry.getValue();

        if (value == null) {
            throw new IllegalArgumentException("Missing tasId for delete");
        }

        // UPDATE teaching_academic_staff is_active = 1 WHERE tas_id = tas_id

        //tas value deleted by tas_id
        repo.deleteTAS(value);
    }
}