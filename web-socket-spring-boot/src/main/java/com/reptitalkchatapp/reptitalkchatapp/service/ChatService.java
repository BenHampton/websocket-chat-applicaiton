package com.reptitalkchatapp.reptitalkchatapp.service;

import com.reptitalkchatapp.reptitalkchatapp.model.Message;
import com.reptitalkchatapp.reptitalkchatapp.util.MessageDatabaseUtil;
import com.reptitalkchatapp.reptitalkchatapp.util.ChatServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChatService {

    private ChatServiceUtil chatServiceUtil;
    private MessageDatabaseUtil messageDatabaseUtil;

    public ChatService(final ChatServiceUtil chatServiceUtil,
                       final MessageDatabaseUtil messageDatabaseUtil){
        this.chatServiceUtil = chatServiceUtil;
        this.messageDatabaseUtil = messageDatabaseUtil;
    }

    public Message retrieveUserConnectionStatus(Message message, String connectionStatus){

        Message connectionMessage = chatServiceUtil.generateUserConnectionMessage(message);

        putMessageIntoPostgresDatabase(connectionMessage);

        log.info("user: " + message.getSender() + " connection status is: " + connectionStatus);

        return connectionMessage;
    }

    public Message retrieveMessageToSend(Message message){

        Message sendMessage = chatServiceUtil.generateMessageToSend(message);

        putMessageIntoPostgresDatabase(sendMessage);

        return sendMessage;
    }

    public void putMessageIntoPostgresDatabase(Message message){

        messageDatabaseUtil.putMessageIntoPostgresDatabase(message);

    }

}
