package com.HuskyGroups.entity;

import java.util.Set;


public class UserDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String description;
    private String link;
    private Set<MembershipDTO> groups;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Set<MembershipDTO> getGroups() {
        return groups;
    }

    public void setGroups(Set<MembershipDTO> groups) {
        this.groups = groups;
    }

    public UserDTO() {
    }

    public UserDTO(String id, String firstName, String lastName, String email, String description, String link) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.description = description;
        this.link = link;
    }

    public UserDTO(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.description = user.getDescription();
        this.id = user.getUserId().toString();
        this.link = user.getProfilePic();
    }
}
