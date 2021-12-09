package com.HuskyGroups.controller;

import com.HuskyGroups.database.MembershipRepository;
import com.HuskyGroups.entity.*;
import com.HuskyGroups.service.GroupService;
import com.HuskyGroups.service.UserService;
import com.HuskyGroups.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserService userService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private MembershipRepository membershipRepository;

    @PostMapping("/createUser")
    @PreAuthorize("hasRole('ADMIN')")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/DeleteFromGroup/{memberId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String DeleteFromGroup(@PathVariable String memberId) {
        UUID id = UUID.fromString(memberId);
        membershipRepository.deleteById(id);
        return "Membership deleted! " + memberId;
    }

    @GetMapping("/getAllUsers")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDTO> findAllUsers() {
        List<User> users = userService.getUsers();
        List<UserDTO> toReturn = new ArrayList<>();
        for (User u: users) {
            toReturn.add(new UserDTO(u));
        }
        return toReturn;
    }

    @GetMapping("/getById/{strId}")
    @PreAuthorize("hasRole('ADMIN')")
    public UserDTO getUser(@PathVariable String strId) {
//        System.out.println(strId);
        UUID id = UUID.fromString(strId);
//        System.out.println(id);
        User user = userService.getUserByID(id);
        return new UserDTO(user);
    }

    @DeleteMapping("/deleteById/{strId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteUser(@PathVariable String strId) {
        UUID id = UUID.fromString(strId);
        return userService.deleteUser(id);
    }


    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public UserDTO updateUser(@RequestBody UserDTO user) {
        User toSave = userService.getUserByID(UUID.fromString(user.getId()));
        toSave.setFirstName(user.getFirstName());
        toSave.setLastName(user.getLastName());
        toSave.setDescription(user.getDescription());
        toSave.setProfilePic(user.getLink());
        return new UserDTO(userService.updateUser(toSave));
    }



    @GetMapping("/self/getUser")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public UserDTO getSelf(@RequestHeader("Authorization") String jwtHeader, HttpServletRequest httpServletRequest) {

        if (StringUtils.hasText(jwtHeader) && jwtHeader.startsWith("Bearer ")) {
            String jwt = jwtHeader.substring(7, jwtHeader.length());
            String email = jwtUtils.getUserNameFromJwtToken(jwt);
            User user = userService.getUserByEmail(email);
            return new UserDTO(user);
        }
        return null;
    }

    @PostMapping("/self/addToGroup")
    public MembershipDTO addToGroup(@RequestBody MembershipDTO member) {
        User user = userService.getUserByID(UUID.fromString(member.getUserId()));
        Group group = groupService.getGroupByID(UUID.fromString(member.getGroupId()));
        Membership membership = membershipRepository.save(new Membership(user, group));
        System.out.println(user.getGroups());
        return new MembershipDTO(membership);
    }

    // Delete self from
}
