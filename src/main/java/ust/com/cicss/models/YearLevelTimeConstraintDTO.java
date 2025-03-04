package ust.com.cicss.models;

public class YearLevelTimeConstraintDTO {

    private String yearLevelTimeConstraintId;
    private Restrictions restrictions;

    public YearLevelTimeConstraintDTO() {
    }

    public YearLevelTimeConstraintDTO(String yearLevelTimeConstraintId, Restrictions restrictions) {
        this.yearLevelTimeConstraintId = yearLevelTimeConstraintId;
        this.restrictions = restrictions;
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
}
