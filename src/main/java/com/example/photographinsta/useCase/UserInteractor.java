package com.example.photographinsta.useCase;

import com.example.photographinsta.domain.adapter.UserRepository;
import com.example.photographinsta.domain.model.User;
import com.example.photographinsta.exception.AlreadyExistsException;

public class UserInteractor {

    private final UserRepository userRepository;

    public UserInteractor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) throws AlreadyExistsException {
        validateUserNotExists(user);
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public User inactivateUser(String username) throws IllegalArgumentException {
        if (username == null) {
            throw new IllegalArgumentException("Username is mandotory");
        }
        return userRepository.inactivate(username);
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
