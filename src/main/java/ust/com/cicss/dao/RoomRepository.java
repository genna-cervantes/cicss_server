package ust.com.cicss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import ust.com.cicss.models.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO rooms (room_id, main_department, type) VALUES (?1, ?2, ?3) "
            + "ON CONFLICT (room_id) DO UPDATE SET is_active = true", nativeQuery = true)
    void addRoom(String roomId, String department, String type);

    @Query("select r from Room r where r.roomId=?1")
    Room getRoomDetails(String roomId);

    @Query(value = "SELECT room_id FROM rooms WHERE main_department=?1 AND is_active = true ORDER BY room_id", nativeQuery = true)
    String[] getRoomIdsByDepartment(String department);

    @Modifying
    @Transactional
    @Query(value = "UPDATE rooms SET department = ?2 WHERE room_id = ?1 AND is_active = true", nativeQuery = true)
    void updateDepartment(String room_id, String department);

    @Modifying
    @Transactional
    @Query(value = "UPDATE rooms SET type = ?2 WHERE room_id = ?1 AND is_active = true", nativeQuery = true)
    void updateType(String room_id, String type);

    @Modifying
    @Transactional
    @Query(value = "UPDATE rooms SET is_active = false WHERE room_id = ?1", nativeQuery = true)
    void deleteRoom(String room_id);
}
