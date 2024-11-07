package com.rent_rooms.RentRooms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RentRoomsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentRoomsApplication.class, args);
	}
}
