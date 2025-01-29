package com.rent_rooms.RentRooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/rooms")
public class RoomsController {

    @Autowired
    private RoomService roomService;
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        return new ResponseEntity<>(roomService.allRooms(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createRoom(
            @RequestParam String username, 
            @RequestBody Room newRoom
    ) {
        User owner = userService.findUserByUsername(username);
        if (owner == null) {
            return new ResponseEntity<>("Owner (User) not found", HttpStatus.NOT_FOUND);
        }

        newRoom.setOwnerUsername(username);

        roomService.saveRoom(newRoom);

        return new ResponseEntity<>("Room created successfully", HttpStatus.OK);
    }
}
