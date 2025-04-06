package ust.com.cicss.models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class YearLevelDayConstraintDTO {

    private String yearLevelDayConstraintId;

    private String[] availableDays;

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
