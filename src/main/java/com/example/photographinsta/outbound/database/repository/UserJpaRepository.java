package com.example.photographinsta.outbound.database.repository;

import com.example.photographinsta.outbound.database.model.UserDatabase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends CrudRepository<UserDatabase, Long> {

    Optional<UserDatabase> findByUsername(String username);
}
