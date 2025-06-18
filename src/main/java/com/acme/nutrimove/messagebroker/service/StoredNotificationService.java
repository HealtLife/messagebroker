package com.acme.nutrimove.messagebroker.service;

import com.acme.nutrimove.messagebroker.domain.StoredNotification;
import com.acme.nutrimove.messagebroker.dto.NotificationDto;
import com.acme.nutrimove.messagebroker.feign.NotificationClient;
import com.acme.nutrimove.messagebroker.infrastructure.StoredNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoredNotificationService {

    @Autowired
    private StoredNotificationRepository repository;

    @Autowired
    private NotificationClient notificationClient;

    // Recibe y guarda la notificación
    public void receiveNotification(NotificationDto dto) {
        StoredNotification entity = new StoredNotification(
                dto.getUserId(),
                dto.getMessage(),
                dto.getType(),
                dto.getStatus(),
                dto.getTimestamp() != null ? dto.getTimestamp() : LocalDateTime.now()
        );
        repository.save(entity);
    }

    // Envía todas las notificaciones pendientes a NotificationService y las elimina si se envían con éxito
    public void dispatchStoredNotifications() {
        List<StoredNotification> storedNotifications = repository.findAll();

        List<StoredNotification> sentNotifications = storedNotifications.stream()
                .filter(notification -> {
                    try {
                        NotificationDto dto = new NotificationDto();
                        dto.setUserId(notification.getUserId());
                        dto.setMessage(notification.getMessage());
                        dto.setType(notification.getType());
                        dto.setStatus(notification.getStatus());
                        dto.setTimestamp(notification.getTimestamp());

                        notificationClient.sendNotification(dto);
                        return true;
                    } catch (Exception e) {
                        System.err.println("Error al enviar notificación: " + e.getMessage());
                        return false;
                    }
                })
                .collect(Collectors.toList());

        // Elimina las enviadas con éxito
        repository.deleteAll(sentNotifications);
    }
}