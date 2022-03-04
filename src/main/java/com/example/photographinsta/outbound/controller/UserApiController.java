package com.example.photographinsta.outbound.controller;

import com.example.photographinsta.adapter.controller.UserBaseController;
import com.example.photographinsta.adapter.model.UserRepresentation;
import com.example.photographinsta.exception.AlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserApiController {

    private UserBaseController userBaseController;

    @Autowired
    public UserApiController(UserBaseController userBaseController) {
        this.userBaseController = userBaseController;
    }

    @PostMapping
    public ResponseEntity<UserRepresentation> newUser(@RequestBody UserRepresentation userRepresentation) {
        try {
            UserRepresentation userRepresentationResponse = userBaseController.newUser(userRepresentation);
            return new ResponseEntity<>(userRepresentationResponse, HttpStatus.OK);
        } catch (AlreadyExistsException alreadyExistsException) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserRepresentation> findByUsername(@PathVariable("username") String username) {
        UserRepresentation userRepresentationResponse = userBaseController.findByUsername(username);
        if (userRepresentationResponse != null) {
            return new ResponseEntity<>(userRepresentationResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
