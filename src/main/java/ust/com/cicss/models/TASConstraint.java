

package ust.com.cicss.models;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class TASConstraint {

    private String tasId;
    private String name;
    private int units;
    private String[] courses;
    private Restrictions restrictions;

    public TASConstraint() {
    }

    public TASConstraint(String tasId, String name, int units, String[] courses, Restrictions restrictions) {
        this.tasId = tasId;
        this.name = name;
        this.units = units;
        this.courses = courses;
        this.restrictions = restrictions;
    }

    public String getTasId() {
        return tasId;
    }

    public void setTasId(String tasId) {
        this.tasId = tasId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public Restrictions getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }
}
