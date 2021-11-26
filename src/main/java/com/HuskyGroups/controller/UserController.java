package com.HuskyGroups.controller;

import com.HuskyGroups.entity.User;
import com.HuskyGroups.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/getById/{strId}")
    public User getUser(@PathVariable String strId) {
        System.out.println(strId);
        UUID id = UUID.fromString(strId);
        System.out.println(id);
        return userService.getUserByID(id);
    }

}
