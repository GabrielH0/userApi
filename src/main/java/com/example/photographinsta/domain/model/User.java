package com.example.photographinsta.domain.model;

import java.time.LocalDate;

public class User {

    private String username;

    private String password;

    private LocalDate birthDate;

    private String occupation;

    public User(String username, String password, LocalDate birthDate, String occupation) {
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.occupation = occupation;
        this.validate();
    }

    private void validate() {
        validatePassword(this.password);
        validateUsername(this.username);
        validateBirthDate(this.birthDate);
    }

    private void validateBirthDate(LocalDate birthDate) {
        if (birthDate != null && !birthDateIsValid()) {
            throw new IllegalArgumentException("Invalid birth date");
        }
    }

    private boolean birthDateIsValid() {
        final int LIMIT_AGE = 150;
        return birthDate.isAfter(LocalDate.now().minusYears(LIMIT_AGE)) && birthDate.isBefore(LocalDate.now());
    }

    private void validateUsername(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Username can not be null");
        }
    }

    private void validatePassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Username can not be null");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        validateUsername(username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        validatePassword(password);
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        validateBirthDate(birthDate);
        this.birthDate = birthDate;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
