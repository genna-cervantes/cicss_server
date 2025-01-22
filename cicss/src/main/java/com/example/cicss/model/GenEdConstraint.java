package com.example.cicss.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;
import java.util.Map;

@Entity
public class GenEdConstraint {

    @Id
    private String genEdConstraintId;
    private String courseTitle;
    private String courseCode;
    @ElementCollection
    private List<String> timeRestriction;
    @ElementCollection
    private List<String> dayPairRestriction;

    public GenEdConstraint()
    {

    }

    public GenEdConstraint(String genEdConstraintId, String courseTitle, String courseCode, List<String> timeRestriction, List<String> dayPairRestriction) {
        this.genEdConstraintId = genEdConstraintId;
        this.courseTitle = courseTitle;
        this.courseCode = courseCode;
        this.timeRestriction = timeRestriction;
        this.dayPairRestriction = dayPairRestriction;
    }

    public String getGenEdConstraintId() {
        return genEdConstraintId;
    }

    public void setGenEdConstraintId(String genEdConstraintId) {
        this.genEdConstraintId = genEdConstraintId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public List<String> getTimeRestriction() {
        return timeRestriction;
    }

    public void setTimeRestriction(List<String> timeRestriction) {
        this.timeRestriction = timeRestriction;
    }

    public List<String> getDayPairRestriction() {
        return dayPairRestriction;
    }

    public void setDayPairRestriction(List<String> dayPairRestriction) {
        this.dayPairRestriction = dayPairRestriction;
    }
}
