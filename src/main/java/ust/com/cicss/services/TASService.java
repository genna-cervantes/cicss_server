
package ust.com.cicss.services;

import java.util.ArrayList;
import java.util.List;
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

    public boolean authByEmail(String email) {

        return tasRepo.authByEmail(email);
    }

//    public ArrayList<Object> getAllTASConstraints() {
//        ArrayList<String> tasIds = tasRepo.getAllTASIds();
//        ArrayList<Object> tasConstraints = new ArrayList<>();
//        for (int i = 0; i < tasIds.size(); i++) {
//            Object obj = new Object();
//
//            String name = tasRepo.findById(tasIds.get(i))
//                    .map(TAS::getName)
//                    .orElseThrow(() -> new RuntimeException("Name not found"));
//
//            int units = tasRepo.findById(tasIds.get(i))
//                    .map(TAS::getUnits)
//                    .orElseThrow(() -> new RuntimeException("Name not found"));
//
//            String[] courses = tasRepo.findById(tasIds.get(i))
//                    .map(TAS::getCourses)
//                    .orElseThrow(() -> new RuntimeException("Name not found"));
//
//            Restrictions restrictions = tasRepo.findById(tasIds.get(i))
//                    .map(TAS::getRestrictions)
//                    .orElseThrow(() -> new RuntimeException("Restrictions not found"));
//        }
//        return tasConstraints;
//    }

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
