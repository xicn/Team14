package com.HuskyGroups.service;

import com.HuskyGroups.database.GroupRepository;
import com.HuskyGroups.entity.Group;
import com.HuskyGroups.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    // Create
    public Group saveGroup(Group group) {
        return groupRepository.save(group);
    }
    public List<Group> saveGroups(List<Group> groups) {
        return groupRepository.saveAll(groups);
    }

    // Read
    public List<Group> getGroups() {
        return groupRepository.findAll();
    }
    public Group getGroupByID(UUID id) {
        return groupRepository.findById(id).orElse(null);
    }

    // Delete
    public String deleteGroup(UUID id) {
        groupRepository.deleteById(id);
        return "Group deleted!! " + id;
    }

    // Update
    public Group updateGroup(Group group) {
        Group existingGroup = groupRepository.findById(group.getGroupID()).orElse(null);
        return groupRepository.save(existingGroup);
    }

}
