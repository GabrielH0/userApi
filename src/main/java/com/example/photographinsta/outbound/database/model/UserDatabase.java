package com.example.photographinsta.outbound.database.model;

import com.example.photographinsta.domain.model.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

@Table(name = "user_")
@Entity
public class UserDatabase {

    private static final AtomicLong idCounter = new AtomicLong();

    @Id
    @GeneratedValue
    private final Long id = createId();

    private String username;

    private String password;

    private LocalDate birthDate;

    private String occupation;

    private boolean active = true;

    public UserDatabase(String username, String password, LocalDate birthDate, String occupation, boolean active) {
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.occupation = occupation;
        this.active = active;
    }

    protected UserDatabase() {
    }

    public User toUser() {
        return new User(username, password, birthDate, occupation, active);
    }

    private Long createId() {
        return idCounter.getAndIncrement();
    }

    public Long getId() {
        return id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
