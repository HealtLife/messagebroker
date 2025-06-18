package com.acme.nutrimove.messagebroker;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void sendMessage(String message, String routingKey) {
        rabbitTemplate.convertAndSend("myExchange", routingKey, message);
    }
}
