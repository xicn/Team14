package com.HuskyGroups.entity;

public class GroupDTO {
    private String name;
    private String groupID;
    private String topicID;
    private String description;
    private String membersOnly;

    public GroupDTO() {
    }

    public GroupDTO(Group group) {
        this.name = group.getTitle();
        this.groupID = group.getGroupID().toString();
        this.topicID = group.getTopic().getTopicID().toString();
        this.description = group.getDescription();
        this.membersOnly = group.getMembersOnly();
    }

    public GroupDTO(String name, String groupID, String topicID, String description, String membersOnly) {
        this.name = name;
        this.groupID = groupID;
        this.topicID = topicID;
        this.description = description;
        this.membersOnly = membersOnly;
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
