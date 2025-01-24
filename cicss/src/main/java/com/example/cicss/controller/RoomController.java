package com.example.cicss.controller;

import com.example.cicss.model.Room;
import com.example.cicss.dao.RoomRepository;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
@Table(name = "room")
public class RoomController {

    @Autowired
    private RoomRepository repo;


    @GetMapping
    public List<Room> getAllRooms()
    {
        return repo.findAll();
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<Room> findRoom(@PathVariable String roomId) {
        Room room = repo.getRoomDetails(roomId);
        if (room == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(room);
    }

    @PostMapping
    public void addRoom(@Validated @RequestBody Room room)
    {
        repo.save(room);
    }

    @PutMapping("/")
    public void updateRoom(@RequestBody Room room)
    {
        repo.save(room);
    }

    @DeleteMapping("/{roomId}")
    public void deleteRoom(@PathVariable String roomId)
    {
        repo.deleteById(roomId);
    }
}
