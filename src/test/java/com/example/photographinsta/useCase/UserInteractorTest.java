package com.example.photographinsta.useCase;

import com.example.photographinsta.domain.adapter.UserRepository;
import com.example.photographinsta.domain.model.User;
import com.example.photographinsta.exception.AlreadyExistsException;
import com.example.photographinsta.outbound.rabbitmq.impl.UserQueueDispatcherImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.time.LocalDate;

@RunWith(JUnit4.class)
public class UserInteractorTest {

    private UserInteractor userInteractor;

    private UserRepository userRepository;

    private User user;

    @Before
    public void init() {
        userRepository = Mockito.mock(UserRepository.class);
        RabbitTemplate rabbitTemplateMock = Mockito.mock(RabbitTemplate.class);
        userInteractor = new UserInteractor(userRepository, new UserQueueDispatcherImpl(rabbitTemplateMock));
        user = new User("Gabriel", "123",  LocalDate.of(1999, 9, 20),
                "Developer", true);
    }

    @Test
    public void newUserTest() throws AlreadyExistsException {
        Mockito.when(userRepository.save(user)).thenReturn(user);
        Assertions.assertNotNull(userInteractor.saveUser(user));
    }

    @Test
    public void newUser_usernameInUseShouldThrowExceptionTest() {
        Mockito.when(userRepository.findByUsername("Gabriel1")).thenReturn(new User("Gabriel", "123",
                LocalDate.of(1999, 9, 20), "Developer", true));
        Assertions.assertThrows(AlreadyExistsException.class,
                () -> userInteractor.saveUser(user));
    }

    @Test
    public void updateUserTest() {
        Mockito.when(userRepository.save(user)).thenReturn(user);
        Assertions.assertNotNull(userInteractor.updateUser(user));
    }
}
