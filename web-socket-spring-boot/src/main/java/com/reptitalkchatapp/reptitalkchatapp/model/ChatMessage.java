package com.reptitalkchatapp.reptitalkchatapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatMessage {

    private MessageType type; //actionTpye

    private String content; //message

    private String sender; //sender

    private String date; //timestamp

//    public enum MessageType {
//        CHAT,
//        LEAVE,
//        JOIN
//    }
}
