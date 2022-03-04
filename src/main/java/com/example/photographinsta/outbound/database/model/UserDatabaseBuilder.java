package com.example.photographinsta.outbound.database.model;

public final class UserDatabaseBuilder {
    private Long id;
    private String username;
    private String password;

    private UserDatabaseBuilder() {
    }

    public static UserDatabaseBuilder userDatabase() {
        return new UserDatabaseBuilder();
    }

    public UserDatabaseBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public UserDatabaseBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserDatabaseBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserDatabase build() {
        UserDatabase userDatabase = new UserDatabase();
        userDatabase.setId(id);
        userDatabase.setUsername(username);
        userDatabase.setPassword(password);
        return userDatabase;
    }
}
