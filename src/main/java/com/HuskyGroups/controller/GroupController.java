package com.HuskyGroups.controller;

import com.HuskyGroups.entity.Group;
import com.HuskyGroups.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/getGroups")
    public List<Group> getGroup() {
        return groupService.getAll();
    }
}
