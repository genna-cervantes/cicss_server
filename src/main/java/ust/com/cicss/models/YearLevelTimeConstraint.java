package ust.com.cicss.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;

@Entity
@Table(name = "year_level_time_constraints")
public class YearLevelTimeConstraint {
    @Id
    @Column(name = "year_level_time_constraint_id")
    private String yearLevelTimeConstraintId;
    @Column(name = "department")
    private String department;
    @Column(name = "restrictions")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<Integer, TimeBlock> restrictions;

    public YearLevelTimeConstraint() {
    }

    public YearLevelTimeConstraint(String yearLevelTimeConstraintId, String department, Map<Integer, TimeBlock> restrictions) {
        this.yearLevelTimeConstraintId = yearLevelTimeConstraintId;
        this.department = department;
        this.restrictions = restrictions;
    }

    public String getYearLevelTimeConstraintId() {
        return yearLevelTimeConstraintId;
    }

    public void setYearLevelTimeConstraintId(String yearLevelTimeConstraintId) {
        this.yearLevelTimeConstraintId = yearLevelTimeConstraintId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Map<Integer, TimeBlock> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Map<Integer, TimeBlock> restrictions) {
        this.restrictions = restrictions;
    }
}
