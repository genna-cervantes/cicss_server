package ust.com.cicss.models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class YearLevelDayConstraintDTO {
    @Id
    @Column(name = "year_level_day_constraint_id")
    private String yearLevelDayConstraintId;

    @Column(name = "available_days")
    private String[] availableDays;

    @Column(name = "max_days")
    private int maxDays;

    public YearLevelDayConstraintDTO() {
    }

    public YearLevelDayConstraintDTO(String yearLevelDayConstraintId, String[] availableDays, int maxDays) {
        this.yearLevelDayConstraintId = yearLevelDayConstraintId;
        this.availableDays = availableDays;
        this.maxDays = maxDays;
    }

    public String getYearLevelDayConstraintId() {
        return yearLevelDayConstraintId;
    }

    public void setYearLevelDayConstraintId(String yearLevelDayConstraintId) {
        this.yearLevelDayConstraintId = yearLevelDayConstraintId;
    }

    public String[] getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(String[] availableDays) {
        this.availableDays = availableDays;
    }

    public int getMaxDays() {
        return maxDays;
    }

    public void setMaxDays(int maxDays) {
        this.maxDays = maxDays;
    }
}
