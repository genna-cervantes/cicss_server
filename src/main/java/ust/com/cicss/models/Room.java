package ust.com.cicss.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @Column(name="room_id")
    private String roomId;
    @Column(name = "main_department")
    private String mainDepartment;
    @Column(name = "type")
    private String roomType;
    
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Room()
    {

    }

    public Room(String roomId, String mainDepartment, String roomType) {
        this.roomId = roomId;
        this.mainDepartment = mainDepartment;
        this.roomType = roomType;
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

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getDepartment() {
        return mainDepartment;
    }

    public void setDepartment(String mainDepartment) {
        this.mainDepartment = mainDepartment;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}
