package com.mattel.service.impl;

import com.mattel.exception.UserException;
import com.mattel.model.User;
import com.mattel.repository.UserRepository;
import com.mattel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String email, String password) {
        try {
            User user = userRepository.findByEmail(email);
            System.out.println(email);
            if (user == null) {
                throw new UserException("Account is not found");
            }
            if (user.getPassword().equals(password) && user.getEmail().equals(email)) {
                return user;
            } else {
                throw new UserException("Invalid email or password.");
            }
        }catch (NullPointerException a){
            throw new UserException("Account is not found");
        }
    }

    }

