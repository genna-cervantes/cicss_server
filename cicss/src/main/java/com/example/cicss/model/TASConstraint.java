package com.example.cicss.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Map;


@Entity
public class TASConstraint {

    @Id
    private String tasConstraintId;

    private String tasName;
    private String tasStatus;
    @ElementCollection
    private List<String> specialtyCourses;
//    @ElementCollection
//    private List<String> dayRestriction;
//    @ElementCollection
//    private List<String> timeRestriction;
    @ElementCollection
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, TimeBlock> dayAndTimeRestriction;

    public TASConstraint() {
    }

    public TASConstraint(String tasConstraintId, String tasName, String tasStatus, List<String> specialtyCourses, Map<String, TimeBlock> dayAndTimeRestriction) {
        this.tasConstraintId = tasConstraintId;
        this.tasName = tasName;
        this.tasStatus = tasStatus;
        this.specialtyCourses = specialtyCourses;
        this.dayAndTimeRestriction = dayAndTimeRestriction;
    }

    public String getTasConstraintId() {
        return tasConstraintId;
    }

    public void setTasConstraintId(String tasConstraintId) {
        this.tasConstraintId = tasConstraintId;
    }

    public String getTasName() {
        return tasName;
    }

    public void setTasName(String tasName) {
        this.tasName = tasName;
    }

    public String getTasStatus() {
        return tasStatus;
    }

    public void setTasStatus(String tasStatus) {
        this.tasStatus = tasStatus;
    }

    public List<String> getSpecialtyCourses() {
        return specialtyCourses;
    }

    public void setSpecialtyCourses(List<String> specialtyCourses) {
        this.specialtyCourses = specialtyCourses;
    }

    public Map<String, TimeBlock> getDayAndTimeRestriction() {
        return dayAndTimeRestriction;
    }

    public void setDayAndTimeRestriction(Map<String, TimeBlock> dayAndTimeRestriction) {
        this.dayAndTimeRestriction = dayAndTimeRestriction;
    }

    //
//    public TASConstraint(String tasConstraintId, String tasName, String tasStatus, List<String> specialtyCourses, List<String> dayRestriction, List<String> timeRestriction) {
//        this.tasConstraintId = tasConstraintId;
//        this.tasName = tasName;
//        this.tasStatus = tasStatus;
//        this.specialtyCourses = specialtyCourses;
//        this.dayRestriction = dayRestriction;
//        this.timeRestriction = timeRestriction;
//    }
//
//    public String getTasConstraintId() {
//        return tasConstraintId;
//    }
//
//    public void setTasConstraintId(String tasConstraintId) {
//        this.tasConstraintId = tasConstraintId;
//    }
//
//    public String getTasName() {
//        return tasName;
//    }
//
//    public void setTasName(String tasName) {
//        this.tasName = tasName;
//    }
//
//    public String getTasStatus() {
//        return tasStatus;
//    }
//
//    public void setTasStatus(String tasStatus) {
//        this.tasStatus = tasStatus;
//    }
//
//    public List<String> getSpecialtyCourses() {
//        return specialtyCourses;
//    }
//
//    public void setSpecialtyCourses(List<String> specialtyCourses) {
//        this.specialtyCourses = specialtyCourses;
//    }
//
//    public List<String> getDayRestriction() {
//        return dayRestriction;
//    }
//
//    public void setDayRestriction(List<String> dayRestriction) {
//        this.dayRestriction = dayRestriction;
//    }
//
//    public List<String> getTimeRestriction() {
//        return timeRestriction;
//    }
//
//    public void setTimeRestriction(List<String> timeRestriction) {
//        this.timeRestriction = timeRestriction;
//    }
}
