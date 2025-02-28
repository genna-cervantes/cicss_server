package ust.com.cicss.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

    public Room()
    {

    }

    public Room(int roomId, String department, String roomType) {
        this.roomId = roomId;
        this.department = department;
        this.roomType = roomType;
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
