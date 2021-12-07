package com.HuskyGroups.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="HG_User")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "uuid2"
    )
    @Column(name = "User_ID", updatable = false, nullable = false, length = 16)
    private UUID userId;
    @Column(columnDefinition = "TINYTEXT")
    private String firstName;
    @Column(columnDefinition = "TINYTEXT")
    private String lastName;
    @Email(message = "Please provide a valid email address")
    @Column(columnDefinition = "TINYTEXT")
    private String email;

    @NotBlank
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "User_ID"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user")
//    @JsonManagedReference
    private Set<Membership> groups;

    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime modifiedDate;

    @Column(columnDefinition = "TEXT")
    private String description= "Describe yourself!";

    public User(UUID userId, String firstName, String lastName, String email, Set<Role> roles, Set<Membership> groups, LocalDateTime createdDate, LocalDateTime modifiedDate, String description, String profilePic) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = roles;
        this.groups = groups;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.description = description;
        this.profilePic = profilePic;
    }

    public User(UUID userId, String firstName, String lastName, String email, Set<Membership> groups, LocalDateTime createdDate, LocalDateTime modifiedDate, String profilePic, String description) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.groups = groups;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.profilePic = profilePic;
        this.description = description;
    }

    @Column(name = "Image")
    private String profilePic = "https://cdn.icon-icons.com/icons2/1378/PNG/512/avatardefault_92824.png";

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public User(UUID userId, String firstName, String lastName, String email, Set<Membership> groups, LocalDateTime createdDate, LocalDateTime modifiedDate, String profilePic) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.groups = groups;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.profilePic = profilePic;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public User() {
    }

    public User(String firstName, String lastName, String email, Set<Membership> groups, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.groups = groups;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User(UUID userId, String firstName, String lastName, String email, String password, Set<Role> roles, Set<Membership> groups, LocalDateTime createdDate, LocalDateTime modifiedDate, String description, String profilePic) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.groups = groups;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.description = description;
        this.profilePic = profilePic;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
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

    public Set<Membership> getGroups() {
        return groups;
    }

    public void setGroups(Set<Membership> groups) {
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
