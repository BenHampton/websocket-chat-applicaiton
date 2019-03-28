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

//    public ChatMessage retrieveUserJoined(ChatMessage chatMessage){
//
//        log.info(chatMessage.getSender() + " joined");
//
//        ChatMessage joinedChatMessage = chatServiceUtil.generateUserJoinedMessage(chatMessage);
//
//        chatMessageDatabaseUtil.putMessageIntoPostGresDatebase(joinedChatMessage);
//
//        return joinedChatMessage;
//    }

    public Message retrieveUserJoined(Message message){

        log.info(message.getSender() + " joined");

        Message joinedMessage = chatServiceUtil.generateUserJoinedMessage(message);

        messageDatabaseUtil.putMessageIntoPostGresDatebase(joinedMessage);

        return joinedMessage;
    }

    public Message retrieveMessageToSend(Message message){

        Message sendMessage = chatServiceUtil.generateMessageToSend(message);

        messageDatabaseUtil.putMessageIntoPostGresDatebase(sendMessage);

        return sendMessage;
    }

}
