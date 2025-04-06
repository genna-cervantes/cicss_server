package ust.com.cicss.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Table;
import ust.com.cicss.dao.RoomRepository;
import ust.com.cicss.models.Room;

@RestController
@RequestMapping("/rooms")
@Table(name = "rooms")
public class RoomController {

    @Autowired
    private RoomRepository repo;

    @PreAuthorize("hasAuthority('ROLE_Department_Chair') or hasAuthority('ROLE_Student') or hasAuthority('ROLE_TAS')")
    @GetMapping("/{department}")
    public List<Room> getAllRooms(@PathVariable String department)
    {

        System.out.println("This is hit rooms");

        String[] roomIds = repo.getRoomIdsByDepartment(department);
        ArrayList<Room> rooms = new ArrayList<>();
        for (int i = 0; i < roomIds.length; i++){
            Room room = repo.getRoomDetails(roomIds[i]);
            rooms.add(room);
        }

        return rooms;
    }

    // @GetMapping("/{roomId}")
    // public ResponseEntity<Room> findRoom(@PathVariable String roomId) {
    //     Room room = repo.getRoomDetails(roomId);
    //     if (room == null) {
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    //     }
    //     return ResponseEntity.ok(room);
    // }

    @PreAuthorize("hasAuthority('ROLE_Department_Chair')")
    @PostMapping
    public void addRoom(@Validated @RequestBody Room room)
    {
        repo.addRoom(room.getRoomId(), room.getDepartment(), room.getRoomType());
    }

    @PreAuthorize("hasAuthority('ROLE_Department_Chair')")
    @PutMapping
    public void updateRoom(@RequestBody Map<String, Object> updates)
    {
        if (updates.get("roomId") == null) {
            throw new IllegalArgumentException("Missing roomId for update");
        }

        // UPDATE teaching_academic_staff updatecolumn = updatedcolvalue WHERE tas_id = tas_id
        String room_id = String.valueOf(updates.get("roomId"));
        String column = "";
        Object value = null;

        for (Map.Entry<String, Object> entry : updates.entrySet()) {

            if (entry.getKey().equals("roomId")) {
                continue;
            }

            column = entry.getKey(); // Next key as column
            value = entry.getValue(); // Next value
            System.out.println("tas_id: " + room_id + ", column: " + column + ", value: " + value);

            switch (column) {
                case "department":
                    repo.updateDepartment(room_id, (String) value);
                    break;
                case "roomType":
                    repo.updateType(room_id, (String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid column name: " + column);
            }

        }
    }

    @PreAuthorize("hasAuthority('ROLE_Department_Chair')")
    @DeleteMapping
    public void deleteRoom(@RequestBody Map<String, String> room_id) {
        //repo.delete(tasConstraint);
        // REQ BODY: {tas_id: 'PF12345678'}
        if (room_id == null || room_id.isEmpty()) {
            throw new IllegalArgumentException("Missing roomId for delete");
        }

        Map.Entry<String, String> entry = room_id.entrySet().iterator().next();
        String value = entry.getValue();

        if (value == null) {
            throw new IllegalArgumentException("Missing roomId for delete");
        }

        // UPDATE teaching_academic_staff is_active = 1 WHERE tas_id = tas_id
        repo.deleteRoom(value);
    }
}
