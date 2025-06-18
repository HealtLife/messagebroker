package com.acme.nutrimove.messagebroker.service;

import com.acme.nutrimove.messagebroker.dto.NotificationDto;
import com.acme.nutrimove.messagebroker.feign.FeignApiGatewayClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class MessageProcessor {



    @Autowired
    private StoredNotificationService storedNotificationService;

    @Autowired
    private FeignApiGatewayClient apiGatewayClient;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void processNotification(String message) {
        try {
            // Convertir el mensaje JSON a DTO
            NotificationDto dto = objectMapper.readValue(message, NotificationDto.class);

            // Guardar primero en la base de datos
            storedNotificationService.receiveNotification(dto);

            // Enviar al API Gateway
            apiGatewayClient.forwardNotification(dto);

            System.out.println("Notificación procesada y enviada al API Gateway.");

        } catch (Exception e) {
            System.err.println("Error procesando notificación: " + e.getMessage());
        }
    }
}
