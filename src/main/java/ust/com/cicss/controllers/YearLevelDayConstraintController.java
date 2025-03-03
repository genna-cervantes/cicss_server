
package ust.com.cicss.controllers;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{year_level_day_constraint_id}")
    public void updateYearLevelDayConstraint(@PathVariable String year_level_day_constraint_id, @RequestBody Map<String, Object> update)
    {
        // UPDATE year_day_restrictions SET updatecolumn = updatedcolvalue WHERE year_day_restriction_id = year_day_restriction_id
        //repo.save(yldc);
        Map.Entry<String, Object> entry = update.entrySet().iterator().next();
        String column = entry.getKey();   // The column name to update
        Object value = entry.getValue();

        switch (column) {
            case "availableDays":
                repo.updateAvailableDays(year_level_day_constraint_id, (String[]) value);
                break;
            case "maxDays":
                repo.updateMaxDays(year_level_day_constraint_id, (int) value);
                break;
            default:
                throw new IllegalArgumentException("Invalid column name: " + column);
        }
    }

    @DeleteMapping
    public void deleteYearLevelDayConstraint(@RequestBody YearLevelDayConstraint yearLevelDayConstraint)
    {
        // UPDATE year_day_restrictions SET is_active = 0 WHERE year_day_restriction_id = year_day_restriction_id
        repo.delete(yearLevelDayConstraint);
    }
}
