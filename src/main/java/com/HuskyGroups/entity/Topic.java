package com.HuskyGroups.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime modifiedDate;

    public Topic() {
    }

    public Topic(String name, String description, Set<Group> groups) {
        this.name = name;
        this.description = description;
        this.groups = groups;
    }

    public Topic(UUID topicID, String name, String description, Set<Group> groups, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.topicID = topicID;
        this.name = name;
        this.description = description;
        this.groups = groups;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
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

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}

