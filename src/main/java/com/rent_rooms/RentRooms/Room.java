package com.rent_rooms.RentRooms;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "rooms")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    private String roomId;
    private String name;
    private String city;
    private double squareMeters; // in m²
    private double pricePerMonth;
    private String availability; // "Available" or "Occupied"
    private String state;
    private String address;
    private String description;
    private String imageUrl;
    private String ownerUsername;
}
