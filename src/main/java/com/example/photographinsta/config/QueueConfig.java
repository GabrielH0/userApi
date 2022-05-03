package com.example.photographinsta.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Bean
    public Queue configQueue() {
        return QueueBuilder
                .durable("USER")
                .build();
    }
}
