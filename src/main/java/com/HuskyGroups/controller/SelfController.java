package com.HuskyGroups.controller;

import com.HuskyGroups.database.MembershipRepository;
import com.HuskyGroups.entity.*;
import com.HuskyGroups.service.GroupService;
import com.HuskyGroups.service.TopicService;
import com.HuskyGroups.service.UserService;
import com.HuskyGroups.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/self")
public class SelfController {
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserService userService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private MembershipRepository membershipRepository;

    public User getUser(String jwtHeader) {
        if (StringUtils.hasText(jwtHeader) && jwtHeader.startsWith("Bearer ")) {
            String jwt = jwtHeader.substring(7, jwtHeader.length());
            String email = jwtUtils.getUserNameFromJwtToken(jwt);
            User user = userService.getUserByEmail(email);
            return user;
        }
        return null;
    }

    @GetMapping("/getUser")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public UserDTO getSelf(@RequestHeader("Authorization") String jwtHeader) throws RuntimeException {
        User user = getUser(jwtHeader);
        if (user == null) {
            throw new RuntimeException("User not found!");
        }
        return new UserDTO(user);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public UserDTO updateUser(@RequestHeader("Authorization") String jwtHeader, @RequestBody UserDTO user) throws RuntimeException  {
        User toSave = getUser(jwtHeader);
        if (user == null) {
            throw new RuntimeException("User not found!");
        }
        toSave.setFirstName(user.getFirstName());
        toSave.setLastName(user.getLastName());
        toSave.setDescription(user.getDescription());
        toSave.setProfilePic(user.getLink());
        return new UserDTO(userService.updateUser(toSave));
    }


    @PostMapping("/createGroup")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String createGroup(@RequestHeader("Authorization") String jwtHeader, @RequestBody GroupDTO group) throws RuntimeException {
        // Obtain valid user object
        User user = getUser(jwtHeader);
        if (user == null) {
            throw new RuntimeException("User not found!");
        }
        // Obtain valid topic object
        Topic topic = topicService.getTopicByID(UUID.fromString(group.getTopicID()));

        // Construct a new group from topic object
        Group toSave = new Group(group.getName(), group.getDescription(), topic);

        groupService.saveGroup(toSave);

        // Add the user as an owner, owner can only be assigned here and nowhere else
        Membership membership = membershipRepository.save(new Membership(user, toSave, GRole.ROLE_OWNER));


        return "Group created successfully!";
    }



}
