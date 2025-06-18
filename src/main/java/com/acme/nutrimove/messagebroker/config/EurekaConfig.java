package com.acme.nutrimove.messagebroker.config;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;  // Importación correcta
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEurekaClient  // Habilita el registro en Eureka
public class EurekaConfig {
    // Esta clase permite registrar el microservicio en Eureka
}
