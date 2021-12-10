package com.HuskyGroups.controller;

import com.HuskyGroups.entity.*;
import com.HuskyGroups.service.GroupService;
import com.HuskyGroups.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;
    @Autowired
    private TopicService topicService;


    @PostMapping("/createGroup")
    public Group createGroup(@RequestBody GroupDTO group) {
        Topic topic = topicService.getTopicByID(UUID.fromString(group.getTopicID()));
        Group toSave = new Group(group.getName(), group.getDescription(), topic);
        groupService.saveGroup(toSave);
        return null;
//        return groupService.saveGroup();
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

    @GetMapping("/getById/{strId}")
    public GroupDTO getGroup(@PathVariable String strId) {
//        System.out.println(strId);
        UUID id = UUID.fromString(strId);
//        System.out.println(id);
        Group group = groupService.getGroupByID(id);
        return new GroupDTO(group);
    }

    @PutMapping("/update")
    public GroupDTO updateGroup(@RequestBody GroupDTO group) {
        Group toSave = groupService.getGroupByID(UUID.fromString(group.getGroupID()));
        toSave.setTitle(group.getName());
        toSave.setDescription(group.getDescription());
        toSave.setMembersOnly(group.getMembersOnly());
        return new GroupDTO(groupService.updateGroup(toSave));
    }
    
    
    // Function to search groups by name with a string input
    @GetMapping("/searchByGroup/{strName}")
    public List<GroupDTO> searchGroupByGroup(@PathVariable String strName){
    	List<Group> groups = groupService.getGroups();
    	List<GroupDTO> toReturn = new ArrayList<>();
    	// for each group in the groups array, see if the name contains the chars provided
    	for(Group g: groups) {
    		if(g.getTitle().toLowerCase().contains(strName.toLowerCase())) {
    			toReturn.add(new GroupDTO(g));
    		}
    	}
    	return toReturn;
    }
    
    
    // Function to search for groups by topic name with a string input
    @GetMapping("/searchByTopic/{strName}")
    public List<GroupDTO> searchGroupByTopic(@PathVariable String strName){
    	List<Topic> topics = topicService.getTopics();
    	List<GroupDTO> toReturn = new ArrayList<>();
    	// for each topic in the topic array, see if the name contains the chars provided
    	for(Topic t: topics) {
    		if(t.getName().toLowerCase().contains(strName.toLowerCase())) {
    			// get the set of groups within this topic
    			Set<Group> groups = t.getGroups();
    			// for each group, add it to the list of groups to return
    			for(Group g: groups) {
    				toReturn.add(new GroupDTO(g));
    			}
    		}
    	}
    	return toReturn;
    }
    
}
