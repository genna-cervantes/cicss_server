package ust.com.cicss.models;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "gened_constraints")
public class GenEdConstraint {

    @Id
    @Column(name = "gened_constraint_id")
    private String genEdConstraintId;
    @Column(name = "course_title")
    private String courseTitle;
    @Column(name = "course_code")
    private String courseCode;
    @Column(name = "day_and_time_restriction")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, TimeBlock> dayAndTimeRestriction;
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public GenEdConstraint()
    {

    }

    public GenEdConstraint(String genEdConstraintId, String courseTitle, String courseCode, Map<String, TimeBlock> dayAndTimeRestriction) {
        this.genEdConstraintId = genEdConstraintId;
        this.courseTitle = courseTitle;
        this.courseCode = courseCode;
        this.dayAndTimeRestriction = dayAndTimeRestriction;
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

    public Map<String, TimeBlock> getDayAndTimeRestriction() {
        return dayAndTimeRestriction;
    }

    public void setDayAndTimeRestriction(Map<String, TimeBlock> dayAndTimeRestriction) {
        this.dayAndTimeRestriction = dayAndTimeRestriction;
    }
}
