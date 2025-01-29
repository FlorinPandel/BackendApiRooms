package com.rent_rooms.RentRooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@CrossOrigin(origins = "http://localhost:3000")
public class MessagesController {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody MessageRequest request) {
        Room room = roomRepository.findById(request.getRoomId()).orElse(null);
        if (room == null) {
            return ResponseEntity.badRequest().body("Room not found");
        }

        String ownerUsername = room.getOwnerUsername(); 
        if (ownerUsername == null || ownerUsername.isEmpty()) {
            return ResponseEntity.status(404).body("Room has no owner info");
        }

        User owner = userService.findUserByUsername(ownerUsername);
        if (owner == null) {
            return ResponseEntity.status(404).body("Owner not found");
        }

        Message message = new Message(
                request.getSenderName(),
                request.getSenderEmail(),
                request.getContent(),
                request.getRoomId()
        );

        owner.getInbox().add(message);

        userService.saveUser(owner);

        return ResponseEntity.ok("Message sent successfully");
    }
}
