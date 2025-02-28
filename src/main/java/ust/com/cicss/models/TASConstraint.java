package ust.com.cicss.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Map;


@Entity
@Table(name = "tas_constraints")
public class TASConstraint {

    @Id
    @Column(name = "tas_constraint_id")
    private String tasConstraintId;
    @Column(name = "tas_name")
    private String tasName;
    @Column(name = "tas_status")
    private String tasStatus;
    @Column(name = "specialty_courses")
    private List<String> specialtyCourses;
    @Column(name = "day_and_time_restrictions")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, TimeBlock> dayAndTimeRestrictions;

    public TASConstraint() {
    }

    public TASConstraint(String tasConstraintId, String tasName, String tasStatus, List<String> specialtyCourses, Map<String, TimeBlock> dayAndTimeRestrictions) {
        this.tasConstraintId = tasConstraintId;
        this.tasName = tasName;
        this.tasStatus = tasStatus;
        this.specialtyCourses = specialtyCourses;
        this.dayAndTimeRestrictions = dayAndTimeRestrictions;
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

    public Map<String, TimeBlock> getDayAndTimeRestrictions() {
        return dayAndTimeRestrictions;
    }

    public void setDayAndTimeRestrictions(Map<String, TimeBlock> dayAndTimeRestrictions) {
        this.dayAndTimeRestrictions = dayAndTimeRestrictions;
    }
}
