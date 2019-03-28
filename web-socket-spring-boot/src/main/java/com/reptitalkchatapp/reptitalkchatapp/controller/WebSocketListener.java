package com.reptitalkchatapp.reptitalkchatapp.controller;

import com.reptitalkchatapp.reptitalkchatapp.model.Message;
import lombok.extern.slf4j.Slf4j;
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

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @EventListener
    public void handelWebSocketConnectListener(SessionConnectedEvent event){

        log.info("Received a new Web Socket Connection");
    }

    @EventListener
    public void handelWebSocketDisconnectListener(SessionDisconnectEvent event){

        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String userName = (String) headerAccessor.getSessionAttributes().get("username");

        if (userName != null){

            log.info("User Disconnected: " + userName);

            Message message = new Message();
            message.setActionType(Message.MessageType.LEAVE.name());
            message.setSender(userName);

            messagingTemplate.convertAndSend("/topic/greetings", message);
        }

    }

}
