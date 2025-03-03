package ust.com.cicss.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "the course code field is empty")
    private String courseCode;

    @Column(name = "course_name")
    @NotBlank(message = "the course name field is empty")
    private String courseName;

    @Column(name = "units_per_class")
    @Min(value = 2, message = "units per class field is incorrect")
    private int unitsPerClass;

    @Column(name = "course_type")
    @NotBlank(message = "the course type field is empty")
    private String courseType;

    @Column(name = "course_category")
    @NotBlank(message = "the course category field is empty")
    private String courseCategory;

    @Column(name = "total_units")
    @Min(value = 2, message = "total units field is incorrect")
    private int totalUnits;

    @Column(name = "restrictions")
    @JdbcTypeCode(SqlTypes.JSON)
    @NotNull(message = "The restrictions field is null")
    private Restrictions restrictions;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Course() {
    }

    public Course(String courseCode, String courseName, int unitsPerClass, String courseType, String courseCategory, Restrictions restrictions, int totalUnits) {
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

    public Restrictions getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }

    public int getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(int totalUnits) {
        this.totalUnits = totalUnits;
    }
}