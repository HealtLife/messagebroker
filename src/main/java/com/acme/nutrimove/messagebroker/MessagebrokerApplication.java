package com.acme.nutrimove.messagebroker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MessageBrokerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageBrokerApplication.class, args);
    }
}
