package com.example.photographinsta.outbound.database.model;

import com.example.photographinsta.domain.model.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.concurrent.atomic.AtomicLong;

@Table(name = "user_")
@Entity
public class UserDatabase {

    private static AtomicLong idCounter = new AtomicLong();

    @Id
    @GeneratedValue
    private Long id = createId();

    private String username;

    private String password;

    public UserDatabase(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDatabase() {
    }

    public User toUser() {
        return new User(username, password);
    }

    private Long createId() {
        return idCounter.getAndIncrement();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
