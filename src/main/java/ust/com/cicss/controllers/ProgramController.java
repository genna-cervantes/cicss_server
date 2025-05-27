package ust.com.cicss.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ust.com.cicss.dao.ProgramRepository;
import ust.com.cicss.models.Program;

@RestController
@RequestMapping("/programs")
public class ProgramController {

    @Autowired
    private ProgramRepository programRepository;

    @GetMapping
    public List<Program> getAllPrograms() {
        return programRepository.findAll();
    }

    @GetMapping("/specializations/{department}")
    public ResponseEntity<List<String>> getSpecializationsByDepartment(@PathVariable String department) {
        System.out.println("this is getting called bro");

        // Map department codes to full program names
        String programName;
        switch (department.toUpperCase()) {
            case "CS":
                programName = "Computer Science";
                break;
            case "IT":
                programName = "Information Technology";
                break;
            case "IS":
                programName = "Information Systems";
                break;
            default:
                return ResponseEntity.badRequest().build(); // Invalid department code
        }

        List<Program> programs = programRepository.findAll();
        for (Program program : programs) {
            if (program.getProgramName().equalsIgnoreCase(programName)) {
                System.out.println("this is getting called bro 2");
                String[] specs = program.getSpecializations();
                return ResponseEntity.ok(specs != null ? Arrays.asList(specs) : new ArrayList<>());
            }
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Program> getProgramById(@PathVariable Long id) {
        return programRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Program createProgram(@RequestBody Program program) {
        return programRepository.save(program);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Program> updateProgram(@PathVariable Long id, @RequestBody Program updatedProgram) {
        return programRepository.findById(id).map(program -> {
            program.setProgramName(updatedProgram.getProgramName());
            program.setNoYears(updatedProgram.getNoYears());
            program.setDcEmail(updatedProgram.getDcEmail());
            return ResponseEntity.ok(programRepository.save(program));
        }).orElse(ResponseEntity.<Program>notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgram(@PathVariable Long id) {
        if (programRepository.existsById(id)) {
            programRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Add a specialization to a program
    // Add a specialization to a program - Fixed version
    @PostMapping("/{id}/specializations")
    public ResponseEntity<Program> addSpecialization(
            @PathVariable Long id, @RequestBody String specialization) {

        return programRepository.findById(id).map(program -> {
            // Handle null specializations array
            String[] currentSpecializations = program.getSpecializations();
            List<String> specializations;

            if (currentSpecializations == null) {
                specializations = new ArrayList<>();
            } else {
                specializations = new ArrayList<>(Arrays.asList(currentSpecializations));
            }

            if (!specializations.contains(specialization)) {
                specializations.add(specialization);
                program.setSpecializations(specializations.toArray(new String[0]));
                programRepository.save(program);
                return ResponseEntity.ok(program);
            } else {
                return ResponseEntity.badRequest().body(program);
            }
        }).orElse(ResponseEntity.<Program>notFound().build());
    }

    // Delete a specialization from a program
    @DeleteMapping("/{id}/specializations/{specialization}")
    public ResponseEntity<Program> deleteSpecialization(
            @PathVariable Long id, @PathVariable String specialization) {

        // Use Optional explicitly to handle the response type correctly
        Optional<Program> programOptional = programRepository.findById(id);

        if (programOptional.isEmpty()) {
            return ResponseEntity.<Program>notFound().build();
        }

        Program program = programOptional.get();
        List<String> specializations = new ArrayList<>(Arrays.asList(program.getSpecializations()));

        if (!specializations.contains(specialization)) {
            return ResponseEntity.<Program>notFound().build();
        }

        specializations.remove(specialization);
        program.setSpecializations(specializations.toArray(new String[0]));
        Program savedProgram = programRepository.save(program);

        return ResponseEntity.ok(savedProgram);
    }
}
