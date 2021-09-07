package com.mattel.service;

import com.mattel.model.User;

public interface UserService {
    public User login(String email, String password);
}
