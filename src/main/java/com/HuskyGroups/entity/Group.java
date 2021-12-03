package com.HuskyGroups.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="HG_Group")
public class Group {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "uuid2"
    )
    @Column(name = "Group_ID", updatable = false, nullable = false, length = 16)
    private UUID groupID;
    @Column(columnDefinition = "TINYTEXT")
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "TEXT")
    private String membersOnly;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="Topic_ID", nullable=false)
    private Topic topic;

    public Group(UUID groupID, String title, String description, String membersOnly, Topic topic, Set<Membership> students) {
        this.groupID = groupID;
        this.title = title;
        this.description = description;
        this.membersOnly = membersOnly;
        this.topic = topic;
        this.students = students;
    }

    public Set<Membership> getStudents() {
        return students;
    }

    public void setStudents(Set<Membership> students) {
        this.students = students;
    }

    @OneToMany(mappedBy = "group")
    private Set<Membership> students;

    // No arg constructor
    public Group() {
    }

    // All args constructor
    public Group(String title, String description,Topic topic) {
        this.title = title;
        this.description = description;
        this.topic = topic;
    }

    public UUID getGroupID() {
        return groupID;
    }

    public void setGroupID(UUID groupID) {
        this.groupID = groupID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
