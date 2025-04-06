package ust.com.cicss.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "year_level_day_constraints")
public class YearLevelDayConstraint {

    @Id
    @Column(name = "year_level_day_constraint_id")
    @NotBlank(message = "yearLevelConstraintId is empty")
    private String yearLevelDayConstraintId;

    @Column(name = "available_days")
    @NotNull(message = "available_days is null")
    @Size(min = 2)
    private String[] availableDays;

    @Column(name = "max_days")
    @Min(value = 2)
    private int maxDays;

    @Column(name = "department")
    @NotBlank(message = "department field is blank")
    private String department;

    @Column(name = "year_level")
    @Min(value = 1)
    private int yearLevel;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public YearLevelDayConstraint() {
    }

    public YearLevelDayConstraint(String yearLevelDayConstraintId, String[] availableDays, int maxDays, String department, int yearLevel) {
        this.yearLevelDayConstraintId = yearLevelDayConstraintId;
        this.availableDays = availableDays;
        this.maxDays = maxDays;
        this.department = department;
        this.yearLevel = yearLevel;
    }

    @PrePersist
    protected void onCreate()
    {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate()
    {
        this.updatedAt = LocalDateTime.now();
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }
}
