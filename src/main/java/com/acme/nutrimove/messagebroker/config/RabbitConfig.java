package com.acme.nutrimove.messagebroker.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {



    // Cola para las notificaciones
    @Bean
    public Queue notificationQueue() {
        return new Queue("notificationQueue", true);
    }

    // Intercambio de tipo Topic
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("myExchange");
    }




    @Bean
    public Binding notificationBinding(Queue notificationQueue, TopicExchange exchange) {
        return BindingBuilder.bind(notificationQueue)
                .to(exchange)
                .with("notification.routing.key");
    }
}
