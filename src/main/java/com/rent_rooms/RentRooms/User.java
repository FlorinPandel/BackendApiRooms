package com.rent_rooms.RentRooms;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    private String userId;

    private String username;
    private String password;

    private List<String> roomIds = new ArrayList<>();

    private List<Message> inbox = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
