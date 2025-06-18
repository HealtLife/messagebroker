package com.acme.nutrimove.messagebroker.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import com.acme.nutrimove.messagebroker.service.MessageProcessor;

@Service
public class MessageListener {

    private final MessageProcessor messageProcessor;

    public MessageListener(MessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
    }

    /*@RabbitListener(queues = "recommendationQueue")
    public void receiveRecommendation(String message) {
        messageProcessor.processRecommendation(message);
    }*/

    @RabbitListener(queues = "notificationQueue")
    public void receiveNotification(String message) {
        messageProcessor.processNotification(message);
    }
}
