package com.example.photographinsta.domain.adapter;

import com.example.photographinsta.domain.model.User;

public interface UserRepository {

    User findByUsername(String username);

    User save(User user);

}
