package com.example.cicss.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class YearLevelDayConstraint {

    @Id
    private String department;
    private List<String> firstYearAllowedDays;
    private int firstYearMaxDaysOfRecurrence;
    private List<String> secondYearAllowedDays;
    private int secondYearMaxDaysOfRecurrence;
    private List<String> thirdYearAllowedDays;
    private int thirdYearMaxDaysOfRecurrence;
    private List<String> fourthYearAllowedDays;
    private int fourthYearMaxDaysOfRecurrence;

    public YearLevelDayConstraint() {
    }

    public YearLevelDayConstraint(String department, List<String> firstYearAllowedDays, int firstYearMaxDaysOfRecurrence, List<String> secondYearAllowedDays, int secondYearMaxDaysOfRecurrence, List<String> thirdYearAllowedDays, int thirdYearMaxDaysOfRecurrence, List<String> fourthYearAllowedDays, int fourthYearMaxDaysOfRecurrence) {
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
