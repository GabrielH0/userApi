package com.example.photographinsta.useCase;

import com.example.photographinsta.domain.adapter.UserRepository;
import com.example.photographinsta.domain.model.User;
import com.example.photographinsta.exception.AlreadyExistsException;

public class UserInteractor {

    private UserRepository userRepository;

    public UserInteractor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) throws AlreadyExistsException {
        validateUser(user);
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    private void validateUser(User user) throws AlreadyExistsException {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new AlreadyExistsException("Username already in use");
        }
    }
}
