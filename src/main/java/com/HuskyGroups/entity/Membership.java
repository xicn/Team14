package com.HuskyGroups.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="HG_Membership",
        indexes = {@Index(name = "group_user_membership", columnList = "User_ID,Group_ID", unique = true)})
public class Membership {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "uuid2"
    )
    @Column(name = "Membership_ID", updatable = false, nullable = false, length = 16)
    private UUID memberId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "User_ID")
    User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Group_ID")
    Group group;

    // When you are added to group you are default to role member
    GRole groupRole = GRole.ROLE_MEMBER;

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

    public Membership(User user, Group group, GRole role) {
        this.user = user;
        this.group = group;
        this.groupRole = role;
    }

    public Membership(UUID memberId, User user, Group group, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.memberId = memberId;
        this.user = user;
        this.group = group;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Membership(UUID memberId, User user, Group group, GRole groupRole, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.memberId = memberId;
        this.user = user;
        this.group = group;
        this.groupRole = groupRole;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public UUID getMemberId() {
        return memberId;
    }

    public void setMemberId(UUID memberId) {
        this.memberId = memberId;
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

    public GRole getGroupRole() {
        return groupRole;
    }

    public void setGroupRole(GRole groupRole) {
        this.groupRole = groupRole;
    }
}

