package com.example.service;

import com.example.model.User;

public interface UserService {
    User save(User user);

    User findById(Long id);

    User findByEmail(String email);

    void delete(Long id);
}
