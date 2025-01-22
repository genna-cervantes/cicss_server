package com.example.cicss.dao;

import com.example.cicss.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {

    @Query("select r from Room r where r.roomId=?1")
    Room getRoomDetails(String roomId);
}
