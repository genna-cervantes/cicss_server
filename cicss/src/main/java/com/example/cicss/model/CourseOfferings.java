package com.example.cicss.model;

import jakarta.persistence.*;

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
    @Column(name = "courses")
    private List<String> courses;

    public CourseOfferings() {
    }

    public CourseOfferings(String courseOfferingsId, String department, int yearLevel, int semester, String specialization, List<String> courses) {
        this.courseOfferingsId = courseOfferingsId;
        this.department = department;
        this.yearLevel = yearLevel;
        this.semester = semester;
        this.specialization = specialization;
        this.courses = courses;
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

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
}
