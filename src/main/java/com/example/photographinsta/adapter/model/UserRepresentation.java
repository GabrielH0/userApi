package com.example.photographinsta.adapter.model;

import com.example.photographinsta.domain.model.User;

public class UserRepresentation {

    private String username;

    private String password;

    public UserRepresentation(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User toUserModelRepresentation() {
        return new User(this.username, this.password);
    }

    public static UserRepresentation toUserRepresentation(User user) {
        return new UserRepresentation(user.getUsername(), user.getPassword());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
