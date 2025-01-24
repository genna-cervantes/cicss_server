package ust.com.cicss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ust.com.cicss.models.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {

    @Query("select r from Room r where r.roomId=?1")
    Room getRoomDetails(String roomId);
}
