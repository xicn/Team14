package com.HuskyGroups.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime modifiedDate;
}
