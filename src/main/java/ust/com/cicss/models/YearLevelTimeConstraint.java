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

@Entity
@Table(name = "yearLevel_time_constraints")
public class YearLevelTimeConstraint {
    @Id
    @Column(name = "year_time_restrictions_id")
    private String yearLevelTimeConstraintId;

    @Column(name = "restrictions")
    @JdbcTypeCode(SqlTypes.JSON)
    private Restrictions restrictions;

    @Column(name = "year")
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
