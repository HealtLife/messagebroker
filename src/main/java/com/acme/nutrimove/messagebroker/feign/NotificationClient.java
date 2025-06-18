package com.acme.nutrimove.messagebroker.feign;

import com.acme.nutrimove.messagebroker.dto.NotificationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service", url = "http://localhost:8641") // Usa el puerto correcto de tu NotificationService
public interface NotificationClient {

    @PostMapping("/notifications")
    void sendNotification(@RequestBody NotificationDto notificationDto);
}