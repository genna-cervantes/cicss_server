package ust.com.cicss.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "course_offerings")
public class CourseOfferings {
    @Id
    @Column(name = "course_offerings_id")
    private String courseOfferingsId;
    @Column(name = "department")
    private String department;
    @Column(name = "year_level")
    private int yearLevel;
    @Column(name = "semester")
    private int semester;
    @Column(name = "specialization")
    private String specialization;
    @Column(name = "year")
    private int year;
    @Column(name = "courses")
    private List<String> courseIds;
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public CourseOfferings() {
    }

    public CourseOfferings(String courseOfferingsId, String department, int yearLevel, int semester, String specialization, int year, List<String> courseIds) {
        this.courseOfferingsId = courseOfferingsId;
        this.department = department;
        this.yearLevel = yearLevel;
        this.semester = semester;
        this.specialization = specialization;
        this.year = year;
        this.courseIds = courseIds;
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

    public String getCourseOfferingsId() {
        return courseOfferingsId;
    }

    public void setCourseOfferingsId(String courseOfferingsId) {
        this.courseOfferingsId = courseOfferingsId;
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

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<String> courseIds) {
        this.courseIds = courseIds;
    }
}
