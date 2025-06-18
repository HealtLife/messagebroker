package com.acme.nutrimove.messagebroker.feign;

import com.acme.nutrimove.messagebroker.dto.NotificationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "api-gateway", url = "http://localhost:8080")
public interface FeignApiGatewayClient {

    @PostMapping("/notifications/receive")
    void forwardNotification(@RequestBody NotificationDto dto);
}
