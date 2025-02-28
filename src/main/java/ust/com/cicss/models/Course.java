package ust.com.cicss.models;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @Column(name = "course_code")
    private String courseCode;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "units_per_class")
    private int unitsPerClass;
    @Column(name = "course_type")
    private String courseType;
    @Column(name = "course_category")
    private String courseCategory;
    @Column(name = "restrictions")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, TimeBlock> restrictions;
    @Column(name = "total_units")
    private int totalUnits;
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Course() {
    }

    public Course(String courseCode, String courseName, int unitsPerClass, String courseType, String courseCategory, Map<String, TimeBlock> restrictions, int totalUnits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.unitsPerClass = unitsPerClass;
        this.courseType = courseType;
        this.courseCategory = courseCategory;
        this.restrictions = restrictions;
        this.totalUnits = totalUnits;
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

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getUnitsPerClass() {
        return unitsPerClass;
    }

    public void setUnitsPerClass(int unitsPerClass) {
        this.unitsPerClass = unitsPerClass;
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

    public Map<String, TimeBlock> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Map<String, TimeBlock> restrictions) {
        this.restrictions = restrictions;
    }

    public int getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(int totalUnits) {
        this.totalUnits = totalUnits;
    }
}
