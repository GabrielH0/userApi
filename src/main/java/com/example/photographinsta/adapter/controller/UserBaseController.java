package com.example.photographinsta.adapter.controller;

import com.example.photographinsta.adapter.model.UserRepresentation;
import com.example.photographinsta.domain.model.User;
import com.example.photographinsta.exception.AlreadyExistsException;
import com.example.photographinsta.useCase.UserInteractor;
import org.springframework.beans.factory.annotation.Autowired;

public class UserBaseController {

    private final UserInteractor userInteractor;

    @Autowired
    public UserBaseController(UserInteractor userInteractor) {
        this.userInteractor = userInteractor;
    }

    public UserRepresentation newUser(UserRepresentation userRepresentation) throws AlreadyExistsException {
        User user = userInteractor.saveUser(userRepresentation.toUserModelRepresentation());
        return UserRepresentation.toUserRepresentation(user);
    }

    public UserRepresentation findByUsername(String username) {
        return UserRepresentation.toUserRepresentation(userInteractor.findByUsername(username));
    }

    public UserRepresentation inactivateUser(String username) {
        return UserRepresentation.toUserRepresentation(userInteractor.inactivateUser(username));
    }

    public UserRepresentation updateUser(UserRepresentation userRepresentation) {
        User user = userInteractor.updateUser(userRepresentation.toUserModelRepresentation());
        return UserRepresentation.toUserRepresentation(user);
    }
}
