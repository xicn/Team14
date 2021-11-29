package com.HuskyGroups.controller;

import com.HuskyGroups.entity.Group;
import com.HuskyGroups.entity.GroupDTO;
import com.HuskyGroups.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;


    @GetMapping("/createGroup")
    public Group createUser(@RequestBody Group group) {
        return groupService.saveGroup(group);
    }

    @GetMapping("/getAllGroups")
    public List<GroupDTO> findAllUsers() {
        List<Group> groups = groupService.getGroups();
        List<GroupDTO> toReturn = new ArrayList<>();
        for (Group g: groups) {
            toReturn.add(new GroupDTO(g));
        }
        return toReturn;
    }

//    @GetMapping("/getById/{strId}")
//    public UserDTO getUser(@PathVariable String strId) {
////        System.out.println(strId);
//        UUID id = UUID.fromString(strId);
////        System.out.println(id);
//        User user = userService.getUserByID(id);
//        return new UserDTO(user);
//    }
//
//    @DeleteMapping("/deleteById/{strId}")
//    public String deleteUser(@PathVariable String strId) {
//        UUID id = UUID.fromString(strId);
//        return userService.deleteUser(id);
//    }
//
//    @PutMapping("/update")
//    public UserDTO updateUser(@RequestBody UserDTO user) {
//        User toSave = userService.getUserByID(UUID.fromString(user.getId()));
//        toSave.setFirstName(user.getFirstName());
//        toSave.setLastName(user.getLastName());
//        toSave.setDescription(user.getDescription());
//        toSave.setProfilePic(user.getLink());
//        return new UserDTO(userService.updateUser(toSave));
//    }
}
