package com.acme.nutrimove.messagebroker.controller;

import com.acme.nutrimove.messagebroker.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageBrokerController {

    @Autowired
    private MessageSender messageSender;

    @PostMapping("/message-broker/send")
    public void sendMessage(@RequestBody String message) {
        messageSender.sendMessage(message, "notification.routing.key");
    }
}