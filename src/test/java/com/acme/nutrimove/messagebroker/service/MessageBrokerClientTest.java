package com.acme.nutrimove.messagebroker.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import static org.mockito.Mockito.*;

@SpringBootTest
@EnableFeignClients
public class MessageBrokerClientTest {

    @Autowired
    private MessageBrokerClient messageBrokerClient;

    @Test
    public void testSendMessage() {
        String message = "Test message";

        // Llamada al método de MessageBrokerClient
        messageBrokerClient.sendMessage(message);

        // Verificar que el método de envío fue llamado
        verify(messageBrokerClient, times(1)).sendMessage(message);
    }
}
