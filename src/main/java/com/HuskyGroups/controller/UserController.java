package com.HuskyGroups.controller;

import com.HuskyGroups.entity.User;
import com.HuskyGroups.entity.UserDTO;
import com.HuskyGroups.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/getAll")
    public List<UserDTO> findAllUsers() {
        List<User> users = userService.getUsers();
        List<UserDTO> toReturn = new ArrayList<>();
        for (User u: users) {
            toReturn.add(new UserDTO(u));
        }
        return toReturn;
    }

    @GetMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/getById/{strId}")
    public UserDTO getUser(@PathVariable String strId) {
//        System.out.println(strId);
        UUID id = UUID.fromString(strId);
//        System.out.println(id);
        User user = userService.getUserByID(id);
        return new UserDTO(user);
    }

    @PostMapping("/api/v1/new")
    public User saveUser(@RequestBody User user) {
        System.out.println(user);
        return userService.saveUser(user);
    }

    @DeleteMapping("/delete/{strId}")
    public String deleteUser(@PathVariable String strId) {
        UUID id = UUID.fromString(strId);
        return userService.deleteUser(id);
    }

    @PutMapping("/update")
    public UserDTO updateUser(@RequestBody UserDTO user) {
        User toSave = userService.getUserByID(UUID.fromString(user.getId()));
        toSave.setFirstName(user.getFirstName());
        toSave.setLastName(user.getLastName());
        toSave.setDescription(user.getDescription());
        toSave.setProfilePic(user.getLink());
        return new UserDTO(userService.updateUser(toSave));
    }

}
