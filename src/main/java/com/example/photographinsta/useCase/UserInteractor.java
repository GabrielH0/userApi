package com.example.photographinsta.useCase;

import com.example.photographinsta.domain.adapter.UserRepository;
import com.example.photographinsta.domain.model.User;
import com.example.photographinsta.exception.AlreadyExistsException;
import com.example.photographinsta.outbound.rabbitmq.UserQueueDispatcher;

public class UserInteractor {

    private final UserRepository userRepository;
    private UserQueueDispatcher userQueueDispatcher;

    public UserInteractor(UserRepository userRepository, UserQueueDispatcher userQueueDispatcher) {
        this.userRepository = userRepository;
        this.userQueueDispatcher = userQueueDispatcher;
    }

    public User saveUser(User user) throws AlreadyExistsException {
        validateUserNotExists(user);
        User save = userRepository.save(user);
        userQueueDispatcher.send(user);
        return save;
    }

    public User updateUser(User user) {
        User save = userRepository.save(user);
        userQueueDispatcher.send(user);
        return save;
    }

    public User inactivateUser(String username) throws IllegalArgumentException {
        if (username == null) {
            throw new IllegalArgumentException("Username is mandotory");
        }
        User user = userRepository.inactivate(username);
        userQueueDispatcher.send(user);
        return user;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    private void validateUserNotExists(User user) throws AlreadyExistsException {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new AlreadyExistsException("Username already in use");
        }
    }
}
