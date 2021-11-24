package com.HuskyGroups.service;

import com.HuskyGroups.database.UserRepository;
import com.HuskyGroups.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userPepository;

    public User saveUser(User user) {
        return userPepository.save(user);
    }

    public User getUserByID(UUID id) {
        return userPepository.findById(id).orElse(null);
    }
}
