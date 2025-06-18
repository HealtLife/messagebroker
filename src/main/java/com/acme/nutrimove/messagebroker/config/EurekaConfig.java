package com.acme.nutrimove.messagebroker.config;


import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients
public class EurekaConfig {
    // Esta clase permite registrar el microservicio en Eureka
}
