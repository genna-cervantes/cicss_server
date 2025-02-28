package ust.com.cicss.models;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "generated_schedules_cache")
public class GeneratedSchedulesCache {

    @Id
    private String generatedSchedulesCacheId;
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> schedule;
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public GeneratedSchedulesCache() {
    }

    public GeneratedSchedulesCache(String generatedSchedulesCacheId, Map<String, Object> schedule) {
        this.generatedSchedulesCacheId = generatedSchedulesCacheId;
        this.schedule = schedule;
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

    public String getGeneratedSchedulesCacheId() {
        return generatedSchedulesCacheId;
    }

    public void setGeneratedSchedulesCacheId(String generatedSchedulesCacheId) {
        this.generatedSchedulesCacheId = generatedSchedulesCacheId;
    }

    public Map<String, Object> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<String, Object> schedule) {
        this.schedule = schedule;
    }
}
