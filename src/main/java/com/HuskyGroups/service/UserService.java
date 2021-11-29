package com.HuskyGroups.service;

import com.HuskyGroups.database.UserRepository;
import com.HuskyGroups.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userPepository;

    // Create
    public User saveUser(User user) {
        return userPepository.save(user);
    }
    public List<User> saveUsers(List<User> users) {
        return userPepository.saveAll(users);
    }

    // Read
    public List<User> getUsers() {
        return userPepository.findAll();
    }
    public User getUserByID(UUID id) {
        return userPepository.findById(id).orElse(null);
    }
    public User getUserByEmail(String email) {
        return userPepository.findByEmail(email);
    }

    // Delete
    public String deleteUser(UUID id) {
        userPepository.deleteById(id);
        return "User deleted!! " + id;
    }

    // Update
    public User updateUser(User user) {
        User existingUser = userPepository.findById(user.getUserId()).orElse(null);
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setProfilePic(user.getProfilePic());
        return userPepository.save(existingUser);
    }
}
