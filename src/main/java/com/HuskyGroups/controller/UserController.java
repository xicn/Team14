package com.HuskyGroups.controller;

import com.HuskyGroups.database.MembershipRepository;
import com.HuskyGroups.entity.*;
import com.HuskyGroups.service.GroupService;
import com.HuskyGroups.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private MembershipRepository membershipRepository;

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/addToGroup")
    public MembershipDTO addToGroup(@RequestBody MembershipDTO member) {
        User user = userService.getUserByID(UUID.fromString(member.getUserId()));
        Group group = groupService.getGroupByID(UUID.fromString(member.getGroupId()));
        Membership membership = membershipRepository.save(new Membership(user, group));
        System.out.println(user.getGroups());
        return new MembershipDTO(membership);
    }

    @DeleteMapping("/DeleteFromGroup/{memberId}")
    public String DeleteFromGroup(@PathVariable String memberId) {
        UUID id = UUID.fromString(memberId);
        membershipRepository.deleteById(id);
        return "Membership deleted! " + memberId;
    }

    @GetMapping("/getAllUsers")
    public List<UserDTO> findAllUsers() {
        List<User> users = userService.getUsers();
        List<UserDTO> toReturn = new ArrayList<>();
        for (User u: users) {
            toReturn.add(new UserDTO(u));
        }
        return toReturn;
    }

    @GetMapping("/getById/{strId}")
    public UserDTO getUser(@PathVariable String strId) {
//        System.out.println(strId);
        UUID id = UUID.fromString(strId);
//        System.out.println(id);
        User user = userService.getUserByID(id);
        return new UserDTO(user);
    }

    @DeleteMapping("/deleteById/{strId}")
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
