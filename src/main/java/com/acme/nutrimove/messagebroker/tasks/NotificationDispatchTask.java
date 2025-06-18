package com.acme.nutrimove.messagebroker.tasks;

import com.acme.nutrimove.messagebroker.service.StoredNotificationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NotificationDispatchTask {

    private final StoredNotificationService storedNotificationService;

    public NotificationDispatchTask(StoredNotificationService storedNotificationService) {
        this.storedNotificationService = storedNotificationService;
    }

    @Scheduled(fixedDelay = 10000) // Cada 10 segundos
    public void resendStoredNotifications() {
        storedNotificationService.dispatchStoredNotifications();
    }
}