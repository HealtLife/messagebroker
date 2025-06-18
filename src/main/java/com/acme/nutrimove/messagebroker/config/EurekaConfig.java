package com.acme.nutrimove.messagebroker.config;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEurekaClient
public class EurekaConfig {
    // Esta clase permite registrar el microservicio en Eureka
}
