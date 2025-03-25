package ust.com.cicss.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import ust.com.cicss.dao.TASRepository;
import ust.com.cicss.models.TAS;
import ust.com.cicss.models.TASConstraint;

@Service
public class TASService {

    @Autowired
    private TASRepository tasRepo;

    @Autowired
    private ObjectMapper objectMapper;

    public List<Map<String, String>> getAllDetailsByDepartment(String department){
        List<String> tasIds = tasRepo.getAllTASIdsByDepartment(department);

        List<Map<String, String>> tasDetails = new ArrayList<>();
        for(String tasId: tasIds) {
            String tasName = tasRepo.getTASNameFromId(tasId);
            Map<String, String> details = new HashMap<>();
            details.put(tasId, tasName);
            tasDetails.add(details);
        }
        
        return tasDetails;
    }


    public List<TASConstraint> getAllTASConstraintsByDepartment(String department){
        List<String> tasIds = tasRepo.getAllTASIdsByDepartment(department);
        List<TASConstraint> tasConstraints = new ArrayList<>();

        for(String tasId: tasIds) {
            TAS tas = tasRepo.findById(tasId)
                    .orElseThrow(() -> new NoSuchElementException("TAS not found with ID: " + tasId));
            TASConstraint tasConstraint = new TASConstraint(
                    tasId,
                    tas.getName(),
                    tas.getUnits(),
                    tas.getCourses(),
                    tas.getMainDepartment(),
                    tas.getRestrictions()
            );
            // System.out.println("tas constraints");
            // System.out.println(tas.getRestrictions());
            tasConstraints.add(tasConstraint);
        }
        return tasConstraints;
    }

    public List<TASConstraint> getAllTASConstraints() {
        List<String> tasIds = tasRepo.getAllTASIds();
        List<TASConstraint> tasConstraints = new ArrayList<>();

        for(String tasId: tasIds) {
            TAS tas = tasRepo.findById(tasId)
                    .orElseThrow(() -> new NoSuchElementException("TAS not found with ID: " + tasId));
            TASConstraint tasConstraint = new TASConstraint(
                    tasId,
                    tas.getName(),
                    tas.getUnits(),
                    tas.getCourses(),
                    tas.getMainDepartment(),
                    tas.getRestrictions()
            );
            // System.out.println("tas constraints");
            // System.out.println(tas.getRestrictions());
            tasConstraints.add(tasConstraint);
        }
        return tasConstraints;

        // List<String> tables = tasRepo.getAllTables();
        // return tables;
    }

    public TASConstraint getTASConstraintById(String tasId) {
        TAS tas = tasRepo.findById(tasId)
                .orElseThrow(() -> new NoSuchElementException("TAS not found with ID: " + tasId));
        TASConstraint tasConstraint = new TASConstraint(
                tasId,
                tas.getName(),
                tas.getUnits(),
                tas.getCourses(),
                tas.getMainDepartment(),
                tas.getRestrictions()
        );
        return tasConstraint;
    }
}
