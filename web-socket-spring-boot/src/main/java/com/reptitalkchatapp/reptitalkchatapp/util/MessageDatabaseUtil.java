package com.reptitalkchatapp.reptitalkchatapp.util;

import com.reptitalkchatapp.reptitalkchatapp.model.Message;
import com.reptitalkchatapp.reptitalkchatapp.repository.MessageRepository;
import org.springframework.stereotype.Component;

@Component
public class MessageDatabaseUtil {

    private MessageRepository messageRepository;

    public MessageDatabaseUtil(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void putMessageIntoPostgresDatabase(Message message){

        messageRepository.save(message);
    }
}
