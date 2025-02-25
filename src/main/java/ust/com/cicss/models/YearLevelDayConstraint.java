package ust.com.cicss.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "year_level_day_constraints")
public class YearLevelDayConstraint {

    @Id
    @Column(name = "year_level_day_constraint_id")
    private String yearLevelDayConstraintId;
    @Column(name = "department")
    private String department;
    @Column(name = "first_year_allowed_days")
    private List<String> firstYearAllowedDays;
    @Column(name = "first_year_max_days_of_recurrence")
    private int firstYearMaxDaysOfRecurrence;
    @Column(name = "second_year_allowed_days")
    private List<String> secondYearAllowedDays;
    @Column(name = "second_year_max_days_of_recurrence")
    private int secondYearMaxDaysOfRecurrence;
    @Column(name = "third_year_allowed_days")
    private List<String> thirdYearAllowedDays;
    @Column(name = "third_year_max_days_of_recurrence")
    private int thirdYearMaxDaysOfRecurrence;
    @Column(name = "fourth_year_allowed_days")
    private List<String> fourthYearAllowedDays;
    @Column(name = "fourth_year_max_days_of_recurrence")
    private int fourthYearMaxDaysOfRecurrence;
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public YearLevelDayConstraint() {
    }

    public YearLevelDayConstraint(String yearLevelDayConstraintId, String department, List<String> firstYearAllowedDays, int firstYearMaxDaysOfRecurrence, List<String> secondYearAllowedDays, int secondYearMaxDaysOfRecurrence, List<String> thirdYearAllowedDays, int thirdYearMaxDaysOfRecurrence, List<String> fourthYearAllowedDays, int fourthYearMaxDaysOfRecurrence) {
        this.yearLevelDayConstraintId = yearLevelDayConstraintId;
        this.department = department;
        this.firstYearAllowedDays = firstYearAllowedDays;
        this.firstYearMaxDaysOfRecurrence = firstYearMaxDaysOfRecurrence;
        this.secondYearAllowedDays = secondYearAllowedDays;
        this.secondYearMaxDaysOfRecurrence = secondYearMaxDaysOfRecurrence;
        this.thirdYearAllowedDays = thirdYearAllowedDays;
        this.thirdYearMaxDaysOfRecurrence = thirdYearMaxDaysOfRecurrence;
        this.fourthYearAllowedDays = fourthYearAllowedDays;
        this.fourthYearMaxDaysOfRecurrence = fourthYearMaxDaysOfRecurrence;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<String> getFirstYearAllowedDays() {
        return firstYearAllowedDays;
    }

    public void setFirstYearAllowedDays(List<String> firstYearAllowedDays) {
        this.firstYearAllowedDays = firstYearAllowedDays;
    }

    public int getFirstYearMaxDaysOfRecurrence() {
        return firstYearMaxDaysOfRecurrence;
    }

    public void setFirstYearMaxDaysOfRecurrence(int firstYearMaxDaysOfRecurrence) {
        this.firstYearMaxDaysOfRecurrence = firstYearMaxDaysOfRecurrence;
    }

    public List<String> getSecondYearAllowedDays() {
        return secondYearAllowedDays;
    }

    public void setSecondYearAllowedDays(List<String> secondYearAllowedDays) {
        this.secondYearAllowedDays = secondYearAllowedDays;
    }

    public int getSecondYearMaxDaysOfRecurrence() {
        return secondYearMaxDaysOfRecurrence;
    }

    public void setSecondYearMaxDaysOfRecurrence(int secondYearMaxDaysOfRecurrence) {
        this.secondYearMaxDaysOfRecurrence = secondYearMaxDaysOfRecurrence;
    }

    public List<String> getThirdYearAllowedDays() {
        return thirdYearAllowedDays;
    }

    public void setThirdYearAllowedDays(List<String> thirdYearAllowedDays) {
        this.thirdYearAllowedDays = thirdYearAllowedDays;
    }

    public int getThirdYearMaxDaysOfRecurrence() {
        return thirdYearMaxDaysOfRecurrence;
    }

    public void setThirdYearMaxDaysOfRecurrence(int thirdYearMaxDaysOfRecurrence) {
        this.thirdYearMaxDaysOfRecurrence = thirdYearMaxDaysOfRecurrence;
    }

    public List<String> getFourthYearAllowedDays() {
        return fourthYearAllowedDays;
    }

    public void setFourthYearAllowedDays(List<String> fourthYearAllowedDays) {
        this.fourthYearAllowedDays = fourthYearAllowedDays;
    }

    public int getFourthYearMaxDaysOfRecurrence() {
        return fourthYearMaxDaysOfRecurrence;
    }

    public void setFourthYearMaxDaysOfRecurrence(int fourthYearMaxDaysOfRecurrence) {
        this.fourthYearMaxDaysOfRecurrence = fourthYearMaxDaysOfRecurrence;
    }
}
