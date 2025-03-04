package ust.com.cicss.models;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "yearLevel_time_constraints")
public class YearLevelTimeConstraint {
    @Id
    @Column(name = "yearLevel_time_constraint_id")
    private String yearLevelTimeConstraintId;

    @Column(name = "restrictions")
    @JdbcTypeCode(SqlTypes.JSON)
    private Restrictions restrictions;

    @Column(name = "yearLevel")
    private int yearLevel;

    @Column(name = "department")
    private String department;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public YearLevelTimeConstraint() {
    }

    public YearLevelTimeConstraint(String yearLevelTimeConstraintId, Restrictions restrictions, int yearLevel, String department) {
        this.yearLevelTimeConstraintId = yearLevelTimeConstraintId;
        this.restrictions = restrictions;
        this.yearLevel = yearLevel;
        this.department = department;
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

    public String getYearLevelTimeConstraintId() {
        return yearLevelTimeConstraintId;
    }

    public void setYearLevelTimeConstraintId(String yearLevelTimeConstraintId) {
        this.yearLevelTimeConstraintId = yearLevelTimeConstraintId;
    }

    public Restrictions getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }

    public int getyearLevel() {
        return yearLevel;
    }

    public void setyearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
