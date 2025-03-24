package ust.com.cicss.models;

public class CourseDTO {

    private String courseId;
    private String courseCode;
    private String courseName;
    private int totalUnits;
    private String courseType;
    private String courseCategory;

    public CourseDTO() {
    }

    public CourseDTO(String courseId, String courseCode, String courseName, int totalUnits, String courseType, String courseCategory) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.totalUnits = totalUnits;
        this.courseType = courseType;
        this.courseCategory = courseCategory;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
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

    public int getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(int totalUnits) {
        this.totalUnits = totalUnits;
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
}
