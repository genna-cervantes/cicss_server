
package ust.com.cicss.controllers;

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

import com.fasterxml.jackson.databind.ObjectMapper;

import ust.com.cicss.dao.YearLevelDayConstraintRepository;
import ust.com.cicss.models.YearLevelDayConstraint;
import ust.com.cicss.models.YearLevelDayConstraintDTO;

@RestController
@RequestMapping("/yldconstraint")
public class YearLevelDayConstraintController {
    @Autowired
    private YearLevelDayConstraintRepository repo;

    @GetMapping("/{department}/{year_level}")
    public YearLevelDayConstraintDTO getAllYearLevelDayConstraints(@PathVariable String department, @PathVariable int year_level)
    {
        // SELECT year_day_restriction_id, available_days, max_days WHERE year = $1 AND department = $2
        //return repo.findAll();
        return repo.getYLDC(department, year_level);
    }

    @PostMapping
    public void addYearLevelDayConstraint(@RequestBody YearLevelDayConstraint yearLevelDayConstraint)
    {
        // gawa ng custom id for 'YD' + 8 length string random
        String randomString = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        String yearLevelDayConstraintId = "YD" + randomString;
        yearLevelDayConstraint.setYearLevelDayConstraintId(yearLevelDayConstraintId);
        // INSERT INTO year_day_restrictions (year_day_restriction_id, available_days, max_days, year, department) VALUES ()
        repo.save(yearLevelDayConstraint);
    }

    @PutMapping("/{department}/{year_level}")
    public void updateYearLevelDayConstraint(@PathVariable String department, @PathVariable double year_level, @RequestBody Map<String, Object> updates)
    {
        // UPDATE year_day_restrictions SET updatecolumn = updatedcolvalue WHERE year_day_restriction_id = year_day_restriction_id
        //repo.save(yldc)
        String column = "";
        Object value = null;
        ObjectMapper mapper = new ObjectMapper();

        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            column = entry.getKey(); // Next key as column
            value = entry.getValue(); // Next value

            switch (column) {
                case "availableDays":
                    String[] availableDays = mapper.convertValue(value, String[].class);
                    repo.updateAvailableDays(department, year_level, (String[]) availableDays);
                    break;
                case "maxDays":
                    repo.updateMaxDays(department, year_level, Integer.parseInt(value.toString()));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid column name: " + column);
            }
        }

    }

    @DeleteMapping
    public void deleteYearLevelDayConstraint(@RequestBody Map<String, String> yldc_id)
    {
        // UPDATE year_day_restrictions SET is_active = 0 WHERE year_day_restriction_id = year_day_restriction_id
        Map.Entry<String, String> entry = yldc_id.entrySet().iterator().next();
        String value = entry.getValue();
        repo.setInactive(value);
    }
}
