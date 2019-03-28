package com.reptitalkchatapp.reptitalkchatapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ReptiTalkChatAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReptiTalkChatAppApplication.class, args);
    }

}
