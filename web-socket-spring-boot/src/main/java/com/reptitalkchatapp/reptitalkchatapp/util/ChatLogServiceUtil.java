package com.reptitalkchatapp.reptitalkchatapp.util;

import com.reptitalkchatapp.reptitalkchatapp.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ChatLogServiceUtil {

    public List<Message> generateMessages(Page<Message> messagesByPage){

        List<Message> messages = new ArrayList<>();

        messagesByPage.map( pageMessage -> {

            messages.add(pageMessage);

            return pageMessage;
        });

        return messages;
    }
}
