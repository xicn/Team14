package com.HuskyGroups.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="HG_Membership",
        indexes = {@Index(name = "group_user_membership", columnList = "User_ID,Group_ID", unique = true)})
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Membership_ID")
    Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "User_ID")
    User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Group_ID")
    Group group;

    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime modifiedDate;

    public Membership() {
    }

    public Membership(User user, Group group, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.user = user;
        this.group = group;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Membership(User user, Group group) {
        this.user = user;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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

