package com.rent_rooms.RentRooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/users")
public class UserProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/inbox")
    public ResponseEntity<?> getInbox(@RequestParam String username) {
        System.out.println("Fetching inbox for username: " + username);

        try {
            User user = userService.findUserByUsername(username);

            if (user == null) {
                System.out.println("User not found: " + username);
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }

            List<Message> inbox = user.getInbox();
            System.out.println("Inbox for user " + username + ": " + inbox);
            return new ResponseEntity<>(inbox, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println("Error fetching inbox for user: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
