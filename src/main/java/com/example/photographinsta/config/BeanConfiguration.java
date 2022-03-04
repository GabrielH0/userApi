package com.example.photographinsta.config;

import com.example.photographinsta.adapter.controller.UserBaseController;
import com.example.photographinsta.domain.adapter.UserRepository;
import com.example.photographinsta.useCase.UserInteractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserInteractor userInteractor(UserRepository userRepository) {
        return new UserInteractor(userRepository);
    }

    @Bean
    public UserBaseController userBaseController(UserInteractor userInteractor) {
        return new UserBaseController(userInteractor);
    }
}
