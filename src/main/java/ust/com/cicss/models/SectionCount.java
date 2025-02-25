package ust.com.cicss.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "section_count")
public class SectionCount {

    @Id
    @Column(name = "section_count_id")
    private String sectionCountId;
    @Column(name = "department")
    private String department;
    @Column(name = "first_year_section_count")
    private int firstYearSectionCount;
    @Column(name = "second_year_section_count")
    private int secondYearSectionCount;
    @Column(name = "third_year_section_count")
    private int thirdYearSectionCount;
    @Column(name = "fourth_year_section_count")
    private int fourthYearSectionCount;
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public SectionCount() {
    }

    public SectionCount(String sectionCountId, String department, int firstYearSectionCount, int secondYearSectionCount, int thirdYearSectionCount, int fourthYearSectionCount) {
        this.sectionCountId = sectionCountId;
        this.department = department;
        this.firstYearSectionCount = firstYearSectionCount;
        this.secondYearSectionCount = secondYearSectionCount;
        this.thirdYearSectionCount = thirdYearSectionCount;
        this.fourthYearSectionCount = fourthYearSectionCount;
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

    public String getSectionCountId() {
        return sectionCountId;
    }

    public void setSectionCountId(String sectionCountId) {
        this.sectionCountId = sectionCountId;
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
