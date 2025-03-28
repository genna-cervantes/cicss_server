package ust.com.cicss.controllers;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

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

    @PutMapping("/{department}/{year_level}")
    public void updateYearLevelTimeConstraint(@PathVariable String department, @PathVariable int year_level, @RequestBody Map<String, Object> updates)
    {
        // UPDATE year_time_restrictions SET updatecolumn = updatedcolvalue WHERE year_time_restriction_id = year_time_restriction_id
        //repo.save(yearLevelTimeConstraint);
        String column = "";
        Object value = null;
        ObjectMapper mapper = new ObjectMapper();

        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            column = entry.getKey(); // Next key as column
            value = entry.getValue(); // Next value

            switch (column) {
                case "restrictions":
                    Restrictions restrictions = mapper.convertValue(value, Restrictions.class);
                    repo.updateRestrictions(department, year_level, restrictions);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid column name: " + column);
            }
        }

        
    }
}
