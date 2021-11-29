package com.HuskyGroups.entity;

public class TopicDTO {
    private String topicID;
    private String name;
    private String description;

    public TopicDTO() {
    }

    public TopicDTO(String topicID, String name, String description) {
        this.topicID = topicID;
        this.name = name;
        this.description = description;
    }

    public TopicDTO(Topic topic) {
        this.topicID = topic.getTopicID().toString();
        this.name = topic.getName();
        this.description = topic.getDescription();
    }

    public String getTopicID() {
        return topicID;
    }

    public void setTopicID(String topicID) {
        this.topicID = topicID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

