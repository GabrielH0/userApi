package com.example.photographinsta.adapter.controller;

import com.example.photographinsta.adapter.model.UserRepresentation;
import com.example.photographinsta.domain.model.User;
import com.example.photographinsta.exception.AlreadyExistsException;
import com.example.photographinsta.useCase.UserInteractor;

public class UserBaseController {

    private UserInteractor userInteractor;


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
}
