package ust.com.cicss.models;

public class TASConstraint {

    private String tasId;
    private String name;
    private int units;
    private String[] courses;
    private String mainDepartment;
    private Restrictions restrictions;

    public TASConstraint() {
    }

    public TASConstraint(String tasId, String name, int units, String[] courses, String mainDepartment, Restrictions restrictions) {
        this.tasId = tasId;
        this.name = name;
        this.units = units;
        this.courses = courses;
        this.mainDepartment = mainDepartment;
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

    public String getMainDepartment() {
        return mainDepartment;
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

    public void setMainDepartment(String mainDepartment) {
        this.mainDepartment = mainDepartment;
    }

    public Restrictions getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }
}
