package com.group1.energymanager.service;

import com.group1.energymanager.model.User;
import com.group1.energymanager.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user){
        user.setId(UUID.randomUUID().toString());
        return user;
    }
}
