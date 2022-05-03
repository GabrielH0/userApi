package com.example.photographinsta.outbound.rabbitmq.impl;

import com.example.photographinsta.domain.model.User;
import com.example.photographinsta.outbound.rabbitmq.UserQueueDispatcher;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class UserQueueDispatcherImpl implements UserQueueDispatcher {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public UserQueueDispatcherImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void send(User object) {
        rabbitTemplate.convertAndSend("USER-EXCHANGE-BASIC", "USER", object);
    }
}
