package com.codegym.myproject.service;

import com.codegym.myproject.model.User;

public interface UserService {
    void save(User user);
    User findByUserName(String username);

    User findById(int id);
}
