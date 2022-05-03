package com.example.photographinsta.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfig {

    private final Queue userQueue;

    public DirectConfig(Queue userQueue) {
        this.userQueue = userQueue;
    }

    @Bean
    public Exchange directExchange() {
        return ExchangeBuilder
                .directExchange("USER-EXCHANGE-BASIC")
                .durable(true)
                .build();
    }

    @Bean
    public Binding userDirectBinding() {
        return BindingBuilder
                .bind(userQueue)
                .to(directExchange())
                .with("USER")
                .noargs();
    }
}
