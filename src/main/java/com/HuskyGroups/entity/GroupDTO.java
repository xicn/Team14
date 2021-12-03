package com.HuskyGroups.entity;

import java.util.HashSet;
import java.util.Set;

public class GroupDTO {
    private String name;
    private String groupID;
    private String topicID;
    private String description;
    private String membersOnly;
    private Set<MembershipDTO> users;

    public GroupDTO() {
    }

    public GroupDTO(Group group) {
        this.name = group.getTitle();
        this.groupID = group.getGroupID().toString();
        this.topicID = group.getTopic().getTopicID().toString();
        this.description = group.getDescription();
        this.membersOnly = group.getMembersOnly();
        Set<MembershipDTO> toSave = new HashSet<>();
        for (Membership mem: group.getStudents()
        ) {
            toSave.add(new MembershipDTO(mem));
        }
        this.users = toSave;
    }

    public GroupDTO(String name, String groupID, String topicID, String description, String membersOnly) {
        this.name = name;
        this.groupID = groupID;
        this.topicID = topicID;
        this.description = description;
        this.membersOnly = membersOnly;
    }

    public GroupDTO(String name, String groupID, String topicID, String description, String membersOnly, Set<MembershipDTO> users) {
        this.name = name;
        this.groupID = groupID;
        this.topicID = topicID;
        this.description = description;
        this.membersOnly = membersOnly;
        this.users = users;
    }

    public Set<MembershipDTO> getUsers() {
        return users;
    }

    public void setUsers(Set<MembershipDTO> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getTopicID() {
        return topicID;
    }

    public void setTopicID(String topicID) {
        this.topicID = topicID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMembersOnly() {
        return membersOnly;
    }

    public void setMembersOnly(String membersOnly) {
        this.membersOnly = membersOnly;
    }
}
