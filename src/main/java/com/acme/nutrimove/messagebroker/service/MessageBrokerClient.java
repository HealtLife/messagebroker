package com.acme.nutrimove.messagebroker.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "messagebroker-service", url = "http://localhost:8082")
public interface MessageBrokerClient {

    @PostMapping("/message-broker/send")
    void sendMessage(@RequestBody String message);
}
