package com.example.photographinsta.adapter.model;

import java.time.LocalDate;

public final class UserRepresentationBuilder {
    private LocalDate birthDate;
    private String occupation;
    private final String username;
    private final String password;

    public UserRepresentationBuilder(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserRepresentationBuilder withBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public UserRepresentationBuilder withOccupation(String occupation) {
        this.occupation = occupation;
        return this;
    }

    public UserRepresentation build() {
        UserRepresentation userRepresentation = new UserRepresentation(username, password);
        userRepresentation.setBirthDate(birthDate);
        userRepresentation.setOccupation(occupation);
        return userRepresentation;
    }
}
