package com.example.photographinsta.adapter.model;

import com.example.photographinsta.domain.model.User;
import com.example.photographinsta.domain.model.UserBuilder;

import java.time.LocalDate;

public class UserRepresentation {

    private String username;

    private String password;

    private LocalDate birthDate;

    private String occupation;

    public UserRepresentation(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User toUserModelRepresentation() {
        return new UserBuilder(this.username, this.password)
                .withOccupation(occupation)
                .withBirthDate(birthDate)
                .build();
    }

    public static UserRepresentation toUserRepresentation(User user) {
        return new UserRepresentationBuilder(user.getUsername(), user.getPassword())
                .withOccupation(user.getOccupation())
                .withBirthDate(user.getBirthDate())
                .build();
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
