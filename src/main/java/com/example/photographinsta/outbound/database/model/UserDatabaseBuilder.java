package com.example.photographinsta.outbound.database.model;

import java.time.LocalDate;

public final class UserDatabaseBuilder {
    private final String username;
    private final String password;
    private LocalDate birthDate;
    private String ocupation;
    private boolean active = true;

    public UserDatabaseBuilder(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDatabaseBuilder withBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public UserDatabaseBuilder withOccupation(String occupation) {
        this.ocupation = occupation;
        return this;
    }

    public UserDatabaseBuilder withActive(boolean active) {
        this.active = active;
        return this;
    }

    public UserDatabase build() {
        UserDatabase userDatabase = new UserDatabase(username, password, birthDate, ocupation, active);
        userDatabase.setUsername(username);
        userDatabase.setPassword(password);
        userDatabase.setBirthDate(birthDate);
        userDatabase.setOccupation(ocupation);
        return userDatabase;
    }
}
