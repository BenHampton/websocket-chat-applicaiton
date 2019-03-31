package com.reptitalkchatapp.reptitalkchatapp.controller;

import com.reptitalkchatapp.reptitalkchatapp.model.Message;
import com.reptitalkchatapp.reptitalkchatapp.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@Slf4j
public class WebSocketListener {


    private SimpMessageSendingOperations messagingTemplate;

    private ChatService chatService;

    @Autowired
    WebSocketListener(SimpMessageSendingOperations messageSendingOperations,
                      ChatService chatService){
        this.messagingTemplate = messageSendingOperations;
        this.chatService = chatService;
    }

    @EventListener
    public void handelWebSocketConnectListener(SessionConnectedEvent event){
        log.info("Received a new Web Socket Connection");
    }

    @EventListener
    public void handelWebSocketDisconnectListener(SessionDisconnectEvent event){

        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String userName = (String) headerAccessor.getSessionAttributes().get("username");
        String userAvatarImage = (String) headerAccessor.getSessionAttributes().get("userAvatarImage");

        if (StringUtils.isNotBlank(userAvatarImage) && StringUtils.isNotBlank(userName)){

            log.info("User Disconnected: " + userName);

            Message message = new Message();
            message.setActionType(Message.MessageType.LEAVE.name());
            message.setSender(userName);
            message.setAvatarImage(userAvatarImage);

            messagingTemplate.convertAndSend("/topic/public", chatService.retrieveUserConnectionStatus(message, message.getActionType()));
        }

    }

}
