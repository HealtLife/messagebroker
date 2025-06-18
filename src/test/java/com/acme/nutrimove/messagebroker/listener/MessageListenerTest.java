package com.acme.nutrimove.messagebroker.listener;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MessageListenerTest {

    @Autowired
    private MessageListener messageListener;

    @Test
    public void testReceiveMessage() {
        String message = "Test message from queue";
        messageListener.receiveMessage(message);
        // Verifica que el mensaje sea recibido correctamente
    }
}
