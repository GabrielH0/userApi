package com.example.photographinsta.domain.model;

import java.time.LocalDate;

public final class UserBuilder {
    private String username;
    private String password;
    private LocalDate birthDate;
    private String occupation;

    public UserBuilder(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public UserBuilder withOccupation(String occupation) {
        this.occupation = occupation;
        return this;
    }

    public User build() {
        return new User(username, password, birthDate, occupation);
    }
}
