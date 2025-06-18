package com.acme.nutrimove.messagebroker.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MessageSenderTest {

    @Autowired
    private MessageSender messageSender;

    @Test
    public void testSendMessage() {
        String message = "Test message";
        //messageSender.sendMessage(message);
    }
}
