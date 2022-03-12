package com.example.photographinsta.outbound.database.repository;

import com.example.photographinsta.outbound.database.model.UserDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.inject.Named;

@Repository
public interface UserJpaRepository extends CrudRepository<UserDatabase, Long> {

    UserDatabase findByUsername(String username);
}
