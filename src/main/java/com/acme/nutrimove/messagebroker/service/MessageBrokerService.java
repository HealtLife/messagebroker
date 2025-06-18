package com.acme.nutrimove.messagebroker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageBrokerService {

    @Autowired
    private MessageSender messageSender;

    public void processMessage(String message) {
        messageSender.sendMessage(message, "recommendation.routing.key");  // Llamada a MessageSender
    }
}
