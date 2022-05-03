package com.example.photographinsta.config;

import com.example.photographinsta.adapter.controller.UserBaseController;
import com.example.photographinsta.domain.adapter.UserRepository;
import com.example.photographinsta.outbound.rabbitmq.impl.UserQueueDispatcherImpl;
import com.example.photographinsta.useCase.UserInteractor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserInteractor userInteractor(UserRepository userRepository, RabbitTemplate rabbitTemplate) {
        return new UserInteractor(userRepository, new UserQueueDispatcherImpl(rabbitTemplate));
    }

    @Bean
    public UserBaseController userBaseController(UserInteractor userInteractor) {
        return new UserBaseController(userInteractor);
    }
}
