package com.reptitalkchatapp.reptitalkchatapp.util;

import com.reptitalkchatapp.reptitalkchatapp.model.Message;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class ChatServiceUtil {

    public Message generateUserConnectionMessage(Message message){

        Message copyMessage = new Message();

        BeanUtils.copyProperties(message, copyMessage);

        String connectionStatusMessage;

        if (StringUtils.equalsIgnoreCase(message.getActionType(), Message.MessageType.JOIN.name())) {
            connectionStatusMessage = "Joined!";
        } else {
            connectionStatusMessage = " Left!";
        }

        copyMessage.setMessage(message.getSender() + " " + connectionStatusMessage);
        copyMessage.setActionType(message.getActionType());
        copyMessage.setTimeStamp(retrieveTimeStamp());
        copyMessage.setAvatarImage(message.getAvatarImage());

        return copyMessage;
    }

    public Message generateMessageToSend(Message message){

        Message copyMessage = new Message();

        BeanUtils.copyProperties(message, copyMessage);

        copyMessage.setSender(message.getSender());
        copyMessage.setActionType(message.getActionType());
        copyMessage.setMessage(message.getMessage());
        copyMessage.setTimeStamp("[" + retrieveTimeStamp() + "]");
        copyMessage.setAvatarImage(message.getAvatarImage());

        return copyMessage;
    }

    private String retrieveTimeStamp(){
        return new SimpleDateFormat("MM/dd/yyyy HH.mm.ss").format(new java.util.Date());
    }
}
