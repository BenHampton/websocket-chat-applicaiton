package com.reptitalkchatapp.reptitalkchatapp.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class Messages {

    private List<Message> messageLog = new ArrayList<>();

    private boolean errorMessage;
}
