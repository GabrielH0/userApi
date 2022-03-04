package com.example.photographinsta.outbound.controller;

import com.example.photographinsta.adapter.controller.UserBaseController;
import com.example.photographinsta.adapter.model.UserRepresentation;
import com.example.photographinsta.exception.AlreadyExistsException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
@Api( value = "User management resource", description = "User management")
public class UserApiController {

    private UserBaseController userBaseController;

    @Autowired
    public UserApiController(UserBaseController userBaseController) {
        this.userBaseController = userBaseController;
    }

    @ApiOperation("Creates a new user")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Sucessfull operation"),
                    @ApiResponse(code = 400, message = "something went wrong in the operation")
            }
    )
    @PostMapping
    public ResponseEntity<UserRepresentation> newUser(@RequestBody UserRepresentation userRepresentation) {
        try {
            UserRepresentation userRepresentationResponse = userBaseController.newUser(userRepresentation);
            return new ResponseEntity<>(userRepresentationResponse, HttpStatus.OK);
        } catch (AlreadyExistsException alreadyExistsException) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation("Search a user with the username passed")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Sucessfull operation"),
                    @ApiResponse(code = 404, message = "Username not found")
            }
    )
    @GetMapping("/{username}")
    public ResponseEntity<UserRepresentation> findByUsername(@PathVariable("username") String username) {
        UserRepresentation userRepresentationResponse = userBaseController.findByUsername(username);
        if (userRepresentationResponse != null) {
            return new ResponseEntity<>(userRepresentationResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
