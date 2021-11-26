package com.HuskyGroups.service;

import com.HuskyGroups.database.GroupRepository;
import com.HuskyGroups.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    public Group getGroupByID(UUID id) {
        return groupRepository.findById(id).orElse(null);
    }

}
