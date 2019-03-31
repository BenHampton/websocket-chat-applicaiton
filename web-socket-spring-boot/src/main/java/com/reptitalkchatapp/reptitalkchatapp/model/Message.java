package com.reptitalkchatapp.reptitalkchatapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "chatRoom")
public class Message {

    public enum MessageType {
        CHAT("CHAT"),
        LEAVE("LEAVE"),
        JOIN("JOIN");

        private final String messageType;

        MessageType(final String messageType){
            this.messageType = messageType;
        }

        private String getMessageType(){
            return this.messageType;
        }
    }

    @Id
    @GeneratedValue(generator = "messageId_generator")
    private Long id;

    @Column(name = "chatRoomMessage")
    private String message;

    @Column(name = "messageSender")
    private String sender;

    @Column(name = "messageActionType")
    private String actionType;

    @Column(name = "messageTimeStamp")
    private String timeStamp;

    @Column(name = "avatarImage")
    private String avatarImage;

}
