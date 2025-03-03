package ust.com.cicss.controllers;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ust.com.cicss.dao.YearLevelTimeConstraintRepository;
import ust.com.cicss.models.Restrictions;
import ust.com.cicss.models.YearLevelTimeConstraint;
import ust.com.cicss.models.YearLevelTimeConstraintDTO;
import ust.com.cicss.services.YearLevelTimeConstraintService;

@RestController
@RequestMapping("/yltconstraints")
public class YearLevelTimeConstraintController {
    @Autowired
    private YearLevelTimeConstraintRepository repo;

    @Autowired
    private YearLevelTimeConstraintService service;

    @GetMapping("/{department}/{year_level}")
    public YearLevelTimeConstraintDTO getAllYearLevelTimeConstraints(@PathVariable String department, @PathVariable int year_level)
    {
        // SELECT year_time_restriction_id, restricitons WHERE year = $1 AND department = $2
//        return repo.findAll();
        return service.getYLTC(department, year_level);
    }

    @PostMapping
    public void addYearLevelTimeConstraint(@RequestBody YearLevelTimeConstraint yearLevelTimeConstraint)
    {
        // gawa ng custom id for 'YT' + 8 length string random
        String randomString = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        String yearLevelTimeConstraintId = "YT" + randomString;
        // INSERT INTO year_day_restrictions (year_time_restriction_id, restrictions, year, department) VALUES ()
        yearLevelTimeConstraint.setYearLevelTimeConstraintId(yearLevelTimeConstraintId);
        repo.save(yearLevelTimeConstraint);
    }

    @PutMapping
    public void updateYearLevelTimeConstraint(@RequestBody Map<String, Object> updates)
    {
        // UPDATE year_time_restrictions SET updatecolumn = updatedcolvalue WHERE year_time_restriction_id = year_time_restriction_id
        //repo.save(yearLevelTimeConstraint);
        boolean firstEntry = true;
        String yearLevelTimeConstraintId = "";

        for(Map.Entry<String, Object> entry: updates.entrySet()) {
            if(firstEntry) {
                yearLevelTimeConstraintId = entry.getValue().toString();
                firstEntry = false;
            }
            else {
                String column = entry.getKey();
                Object value = entry.getValue();

                System.out.println("column: " + column);
                System.out.println("value: " + value);

                switch(column){
                    case "restrictions":
                        System.out.println("Entered restrictions");
                        repo.updateRestrictions(yearLevelTimeConstraintId, (Restrictions) value);
                        break;
                    case "yearLevel":
                        System.out.println("Entered year level");
                        repo.updateYearLevel(yearLevelTimeConstraintId, (int) value);
                        break;
                    case "department":
                        System.out.println("Entered department");
                        repo.updateDepartment(yearLevelTimeConstraintId, (String) value);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid column name: " + column);
                }
            }
        }
    }

    @DeleteMapping
    public void deleteYearLevelTimeConstraint(@RequestBody YearLevelTimeConstraint yearLevelTimeConstraint)
    {
        // UPDATE year_time_restrictions SET is_active = 0 WHERE year_time_restriction_id = year_time_restriction_id
        repo.delete(yearLevelTimeConstraint);
    }
}
