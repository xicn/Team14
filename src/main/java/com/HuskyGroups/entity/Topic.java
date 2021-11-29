package com.HuskyGroups.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="HG_Topic")
public class Topic {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "uuid2"
    )
    @Column(name = "Topic_ID", updatable = false, nullable = false, length = 16)
    private UUID topicID;
    @Column(columnDefinition = "TINYTEXT")
    private String name;
    @Column(columnDefinition = "TINYTEXT")
    private String description;

    // One to many relationship
    @OneToMany(mappedBy="topic", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Group> groups;

    public Topic() {
    }

    public Topic(String name, String description, Set<Group> groups) {
        this.name = name;
        this.description = description;
        this.groups = groups;
    }

    public UUID getTopicID() {
        return topicID;
    }

    public void setTopicID(UUID topicID) {
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

    public Set<Group> getItems() {
        return groups;
    }

    public void setItems(Set<Group> groups) {
        this.groups = groups;
    }
}

