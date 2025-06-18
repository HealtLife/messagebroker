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
        // Llamar al método de MessageSender para enviar el mensaje a RabbitMQ
        messageSender.sendMessage(message, "recommendation.routing.key");  // Clave de enrutamiento para recomendaciones
    }
}
