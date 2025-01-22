package com.example.cicss.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {
    @Id
    private String courseCode;
    private String courseTitle;
    private int unitsPerClass;
    private int totalUnits;
    private String courseType;
    private String courseCategory;
    private String timeRestrictionId;

    public Course()
    {

    }

    public Course(String courseCode, String courseTitle, int unitsPerClass, int totalUnits, String courseType, String courseCategory, String timeRestrictionId) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.unitsPerClass = unitsPerClass;
        this.totalUnits = totalUnits;
        this.courseType = courseType;
        this.courseCategory = courseCategory;
        this.timeRestrictionId = timeRestrictionId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getcourseTitle() {
        return courseTitle;
    }

    public void setcourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getUnitsPerClass() {
        return unitsPerClass;
    }

    public void setUnitsPerClass(int unitsPerClass) {
        this.unitsPerClass = unitsPerClass;
    }

    public int getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(int totalUnits) {
        this.totalUnits = totalUnits;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(String courseCategory) {
        this.courseCategory = courseCategory;
    }

    public String getTimeRestrictionId() {
        return timeRestrictionId;
    }

    public void setTimeRestrictionId(String timeRestrictionId) {
        this.timeRestrictionId = timeRestrictionId;
    }
}
