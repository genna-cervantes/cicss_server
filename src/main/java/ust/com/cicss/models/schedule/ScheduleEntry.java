package ust.com.cicss.models.schedule;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ScheduleEntry {
    @JsonProperty("courseCode")
    private String courseCode;
    @JsonProperty("courseType")
    private String courseType;
    @JsonProperty("room")
    private String room;
    @JsonProperty("startTime")
    private String startTime;
    @JsonProperty("endTime")
    private String endTime;
    @JsonProperty("professorName")
    private String professorName;

    public ScheduleEntry() {
    }
    public ScheduleEntry(String courseCode, String courseType, String room, String startTime, String endTime, String professorName) {
        this.courseCode = courseCode;
        this.courseType = courseType;
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
        this.professorName = professorName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }
}
