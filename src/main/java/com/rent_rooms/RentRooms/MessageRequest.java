package com.rent_rooms.RentRooms;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageRequest {

    private String roomId;
    private String senderName;
    private String senderEmail;
    private String content;
}
