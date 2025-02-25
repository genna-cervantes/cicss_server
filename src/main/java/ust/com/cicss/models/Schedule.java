package ust.com.cicss.models;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "schedules")
public class Schedule {
    @Id
    private String scheduleId;
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> schedule;
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
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Schedule() {
    }

    public Schedule(String scheduleId, Map<String, Object> schedule) {
        this.scheduleId = scheduleId;
        this.schedule = schedule;
        this.csLocked = false;
        this.itLocked = false;
        this.isLocked = false;
        this.csReady = false;
        this.itReady = false;
        this.isReady = false;
        this.csDeploy = false;
        this.itDeploy = false;
        this.isDeploy = false;
        this.active = false;
        this.status = "Not Deployed";
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

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Map<String, Object> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<String, Object> schedule) {
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
