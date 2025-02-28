package ust.com.cicss.models.schedule;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "schedules")
public class Schedule {
    @Id
    private String scheduleId;
    private List<String> roomIds;
    private List<String> tasIds;
    private List<String> yearLevelTimeConstraintIds;
    private List<String> yearLevelDayConstraintIds;
    private List<String> ratingsIds;
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, SectionSchedule> schedule;
    private boolean csLocked;
    private boolean itLocked;
    private boolean isLocked;
    private boolean csReady;
    private boolean itReady;
    private boolean isReady;
    private boolean csDeploy;
    private boolean itDeploy;
    private boolean isDeploy;
    private String status;
    private boolean active;

    public Schedule() {
    }

//    public Schedule(String scheduleId, Map<String, SectionSchedule> schedule, boolean csLocked, boolean itLocked, boolean isLocked, boolean csReady, boolean itReady, boolean isReady, boolean csDeploy, boolean itDeploy, boolean isDeploy, String status, boolean active) {
//        this.scheduleId = scheduleId;
//        this.schedule = schedule;
//        this.csLocked = csLocked;
//        this.itLocked = itLocked;
//        this.isLocked = isLocked;
//        this.csReady = csReady;
//        this.itReady = itReady;
//        this.isReady = isReady;
//        this.csDeploy = csDeploy;
//        this.itDeploy = itDeploy;
//        this.isDeploy = isDeploy;
//        this.status = status;
//        this.active = active;
//    }

    //trial run

    public Schedule(String scheduleId, List<String> roomIds, List<String> tasIds, List<String> yearLevelTimeConstraintIds, List<String> yearLevelDayConstraintIds, List<String> ratingsIds, Map<String, SectionSchedule> schedule, boolean csLocked, boolean itLocked, boolean isLocked, boolean csReady, boolean itReady, boolean isReady, boolean csDeploy, boolean itDeploy, boolean isDeploy, String status) {
        this.scheduleId = scheduleId;
        this.roomIds = roomIds;
        this.tasIds = tasIds;
        this.yearLevelTimeConstraintIds = yearLevelTimeConstraintIds;
        this.yearLevelDayConstraintIds = yearLevelDayConstraintIds;
        this.ratingsIds = ratingsIds;
        this.schedule = schedule;
        this.csLocked = csLocked;
        this.itLocked = itLocked;
        this.isLocked = isLocked;
        this.csReady = csReady;
        this.itReady = itReady;
        this.isReady = isReady;
        this.csDeploy = csDeploy;
        this.itDeploy = itDeploy;
        this.isDeploy = isDeploy;
        this.status = status;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public List<String> getRoomIds() {
        return roomIds;
    }

    public void setRoomIds(List<String> roomIds) {
        this.roomIds = roomIds;
    }

    public List<String> getTasIds() {
        return tasIds;
    }

    public void setTasIds(List<String> tasIds) {
        this.tasIds = tasIds;
    }

    public List<String> getYearLevelTimeConstraintIds() {
        return yearLevelTimeConstraintIds;
    }

    public void setYearLevelTimeConstraintIds(List<String> yearLevelTimeConstraintIds) {
        this.yearLevelTimeConstraintIds = yearLevelTimeConstraintIds;
    }

    public List<String> getYearLevelDayConstraintIds() {
        return yearLevelDayConstraintIds;
    }

    public void setYearLevelDayConstraintIds(List<String> yearLevelDayConstraintIds) {
        this.yearLevelDayConstraintIds = yearLevelDayConstraintIds;
    }

    public List<String> getRatingsIds() {
        return ratingsIds;
    }

    public void setRatingsIds(List<String> ratingsIds) {
        this.ratingsIds = ratingsIds;
    }

    //end of trial code
    public Schedule(Map<String, SectionSchedule> schedule) {
        this.schedule = schedule;
    }

    public Map<String, SectionSchedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<String, SectionSchedule> schedule) {
        this.schedule = schedule;
    }

    public boolean isCsLocked() {
        return csLocked;
    }

    public void setCsLocked(boolean csLocked) {
        this.csLocked = csLocked;
    }

    public boolean isItLocked() {
        return itLocked;
    }

    public void setItLocked(boolean itLocked) {
        this.itLocked = itLocked;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public boolean isCsReady() {
        return csReady;
    }

    public void setCsReady(boolean csReady) {
        this.csReady = csReady;
    }

    public boolean isItReady() {
        return itReady;
    }

    public void setItReady(boolean itReady) {
        this.itReady = itReady;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public boolean isCsDeploy() {
        return csDeploy;
    }

    public void setCsDeploy(boolean csDeploy) {
        this.csDeploy = csDeploy;
    }

    public boolean isItDeploy() {
        return itDeploy;
    }

    public void setItDeploy(boolean itDeploy) {
        this.itDeploy = itDeploy;
    }

    public boolean isDeploy() {
        return isDeploy;
    }

    public void setDeploy(boolean deploy) {
        isDeploy = deploy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
