package com.example.cicss.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SectionCount {

    @Id
    private String department;
    private int firstYearSectionCount;
    private int secondYearSectionCount;
    private int thirdYearSectionCount;
    private int fourthYearSectionCount;

    public SectionCount() {
    }

    public SectionCount(String department, int firstYearSectionCount, int secondYearSectionCount, int thirdYearSectionCount, int fourthYearSectionCount) {
        this.department = department;
        this.firstYearSectionCount = firstYearSectionCount;
        this.secondYearSectionCount = secondYearSectionCount;
        this.thirdYearSectionCount = thirdYearSectionCount;
        this.fourthYearSectionCount = fourthYearSectionCount;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getFirstYearSectionCount() {
        return firstYearSectionCount;
    }

    public void setFirstYearSectionCount(int firstYearSectionCount) {
        this.firstYearSectionCount = firstYearSectionCount;
    }

    public int getSecondYearSectionCount() {
        return secondYearSectionCount;
    }

    public void setSecondYearSectionCount(int secondYearSectionCount) {
        this.secondYearSectionCount = secondYearSectionCount;
    }

    public int getThirdYearSectionCount() {
        return thirdYearSectionCount;
    }

    public void setThirdYearSectionCount(int thirdYearSectionCount) {
        this.thirdYearSectionCount = thirdYearSectionCount;
    }

    public int getFourthYearSectionCount() {
        return fourthYearSectionCount;
    }

    public void setFourthYearSectionCount(int fourthYearSectionCount) {
        this.fourthYearSectionCount = fourthYearSectionCount;
    }
}
