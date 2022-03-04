package com.example.photographinsta.outbound.database.repository;

import com.example.photographinsta.domain.adapter.UserRepository;
import com.example.photographinsta.domain.model.User;
import com.example.photographinsta.outbound.database.model.UserDatabase;
import com.example.photographinsta.outbound.database.model.UserDatabaseBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named
public class PostgresUserRepostory implements UserRepository {

    private UserJpaRepository userJpaRepository;

    @Autowired
    public PostgresUserRepostory(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public User findByUsername(String username) {
        UserDatabase user = userJpaRepository.findByUsername(username);
        if (user != null) {
            return user.toUser();
        }
        return null;
    }

    @Override
    public User save(User user) {
        UserDatabase userDatabase = userJpaRepository.save(UserDatabaseBuilder
                .userDatabase()
                .withUsername(user.getUsername())
                .withPassword(user.getPassword())
                .build());
        return userDatabase.toUser();
    }
}