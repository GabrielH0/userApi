package com.example.photographinsta.domain.model;

import java.time.LocalDate;

public final class UserBuilder {
    private final String username;
    private final String password;
    private LocalDate birthDate;
    private String occupation;
    private boolean active = true;

    public UserBuilder(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserBuilder withBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public UserBuilder withOccupation(String occupation) {
        this.occupation = occupation;
        return this;
    }

    public UserBuilder withActive(boolean active) {
        this.active = active;
        return this;
    }

    public User build() {
        return new User(username, password, birthDate, occupation, active);
    }
}
