package com.reptitalkchatapp.reptitalkchatapp.service;

import com.reptitalkchatapp.reptitalkchatapp.model.MessageLog;
import com.reptitalkchatapp.reptitalkchatapp.model.Message;
import com.reptitalkchatapp.reptitalkchatapp.repository.MessageRepository;
import com.reptitalkchatapp.reptitalkchatapp.util.ChatLogServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ChatLogService {

    private MessageRepository messageRepository;
    private ChatLogServiceUtil chatLogServiceUtil;

    @Autowired
    public ChatLogService(final MessageRepository messageRepository,
                          final ChatLogServiceUtil chatLogServiceUtil){
         this.messageRepository = messageRepository;
         this.chatLogServiceUtil = chatLogServiceUtil;
    }

    public MessageLog retrieveMessages(Pageable pageable){

        MessageLog messageLog = new MessageLog();

        int pages = messageRepository.findAll(pageable).getTotalPages();

        int index = 0;

        while(index <= pages){

            Pageable pageRequest = new PageRequest(index, 20);

            Page<Message> messagesFromPage = messageRepository.findAll(pageRequest);

            messageLog.getMessageLog().addAll(chatLogServiceUtil.generateMessages(messagesFromPage));

            index++;
        }

        return messageLog;
    }
}
