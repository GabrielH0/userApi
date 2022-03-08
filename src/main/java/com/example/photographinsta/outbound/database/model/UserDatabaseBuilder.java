package com.example.photographinsta.outbound.database.model;

import java.time.LocalDate;

public final class UserDatabaseBuilder {
    private final String username;
    private final String password;
    private LocalDate birthDate;
    private String occupation;

    public UserDatabaseBuilder(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDatabaseBuilder withBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public UserDatabaseBuilder withOccupation(String occupation) {
        this.occupation = occupation;
        return this;
    }

    public UserDatabase build() {
        UserDatabase userDatabase = new UserDatabase();
        userDatabase.setUsername(username);
        userDatabase.setPassword(password);
        userDatabase.setBirthDate(birthDate);
        userDatabase.setOccupation(occupation);
        return userDatabase;
    }
}
