package ust.com.cicss.models;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;

public class GenEdConstraint {

//    private String courseId;
    private String courseName;
    private String courseCode;
    @Embedded
    private Restrictions restrictions;

    public GenEdConstraint() {
    }

    public GenEdConstraint(String courseCode, String courseName, Restrictions restrictions) {
//        this.courseId = courseId;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.restrictions = restrictions;
    }

//    public String getCourseId() {
//        return courseId;
//    }
//
//    public void setCourseId(String courseId) {
//        this.courseId = courseId;
//    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Restrictions getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }
}
