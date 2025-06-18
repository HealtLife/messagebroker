package com.acme.nutrimove.messagebroker;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    // Escucha los mensajes de la cola "recommendationQueue"
    @RabbitListener(queues = "recommendationQueue")
    public void receiveRecommendation(String message) {
        System.out.println("Notification service received recommendation: " + message);

        // Lógica para procesar el mensaje, por ejemplo, enviar una notificación al usuario
        // ...
    }

    // Escucha los mensajes de la cola "notificationQueue"
    @RabbitListener(queues = "notificationQueue")
    public void receiveNotification(String message) {
        System.out.println("Notification service received notification: " + message);

        // Lógica para procesar el mensaje
        // ...
    }
}
