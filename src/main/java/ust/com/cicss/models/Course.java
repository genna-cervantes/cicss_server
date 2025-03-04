package ust.com.cicss.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @Column(name = "course_id")
    @NotBlank(message = "the course id field is empty")
    private String courseId;

    @Column(name = "subject_code")
    @NotBlank(message = "the course code field is empty")
    private String subjectCode;

    @Column(name = "name")
    @NotBlank(message = "the course name field is empty")
    private String name;

    @Column(name = "units_per_class")
    @Min(value = 2, message = "units per class field is incorrect")
    private int unitsPerClass;

    @Column(name = "course_type")
    @NotBlank(message = "the course type field is empty")
    private String courseType;

    @Column(name = "category")
    @NotBlank(message = "the course category field is empty")
    private String category;

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

    public Course (String courseId, String name, String subjectCode, Restrictions restrictions){
        this.courseId = courseId;
        this.name = name;
        this.subjectCode = subjectCode;
        this.restrictions = restrictions;
    }

    public Course(String subjectCode, String name, int unitsPerClass, String courseType, String category, Restrictions restrictions, int totalUnits) {
        this.subjectCode = subjectCode;
        this.name = name;
        this.unitsPerClass = unitsPerClass;
        this.courseType = courseType;
        this.category = category;
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

    public String getCourseId() {
        return courseId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getCourseName() {
        return name;
    }

    public void setCourseName(String name) {
        this.name = name;
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

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseCategory() {
        return category;
    }

    public void setCourseCategory(String category) {
        this.category = category;
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
