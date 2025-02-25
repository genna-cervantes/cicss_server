package ust.com.cicss.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @Column(name="room_id")
    private int roomId;
    @Column(name = "department")
    private String department;
    @Column(name = "room_type")
    private String roomType;
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Room()
    {

    }

    public Room(int roomId, String department, String roomType) {
        this.roomId = roomId;
        this.department = department;
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

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}
