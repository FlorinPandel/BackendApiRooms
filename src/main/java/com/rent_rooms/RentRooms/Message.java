package com.rent_rooms.RentRooms;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Message {
    private String senderName;
    private String senderEmail;
    private String content;

    private String relatedRoomId;


    public Message(String senderName, String senderEmail, String content, String relatedRoomId) {
        this.senderName = senderName;
        this.senderEmail = senderEmail;
        this.content = content;
        this.relatedRoomId = relatedRoomId;
    }
}
