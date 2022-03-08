package com.example.photographinsta.outbound.database.repository;

import com.example.photographinsta.outbound.database.model.UserDatabase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserDatabase, Long> {

    UserDatabase findByUsername(String username);

    UserDatabase save();
}
