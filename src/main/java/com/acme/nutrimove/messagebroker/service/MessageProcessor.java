package com.acme.nutrimove.messagebroker.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class MessageProcessor {

    private final NotificationService notificationService;

    public MessageProcessor(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void processRecommendation(String message) {
        // Procesa la recomendación
        System.out.println("Processing recommendation: " + message);

        // Enviar notificación de recomendación
        notificationService.sendRecommendationNotification(message);

        // Lógica adicional (si se requiere, por ejemplo, guardar en base de datos)
    }

    public void processNotification(String message) {
        // Procesa la notificación
        System.out.println("Processing notification: " + message);

        // Lógica para enviar una notificación (como un correo electrónico, SMS, etc.)
        sendNotification(message);

        // Lógica adicional (si se requiere, por ejemplo, actualizar registros en la base de datos)
    }

    private void sendNotification(String message) {
        // Simula el envío de una notificación
        System.out.println("Sending notification: " + message);
        // Aquí se puede integrar con un sistema de notificación real (SMS, correo electrónico, etc.)
    }
}
