package com.reptitalkchatapp.reptitalkchatapp.controller;

import com.reptitalkchatapp.reptitalkchatapp.model.MessageLog;
import com.reptitalkchatapp.reptitalkchatapp.model.Message;
import com.reptitalkchatapp.reptitalkchatapp.repository.MessageRepository;
import com.reptitalkchatapp.reptitalkchatapp.service.ChatLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:8008")
public class ChatLogController {

    private ChatLogService chatLogService;

    @Autowired
    private MessageRepository messageRepository;

    public ChatLogController(final ChatLogService chatLogService){
        this.chatLogService = chatLogService;
    }

    @GetMapping(path = "/messages")
    public ResponseEntity<MessageLog> retrieveMessages(Pageable pageable){
        return new ResponseEntity<>(chatLogService.retrieveMessages(pageable), HttpStatus.OK);
    }

    @PostMapping(path = "/messages")
    public Message createMessage(@Valid @RequestBody Message message){
        return messageRepository.save(message);
    }
}
