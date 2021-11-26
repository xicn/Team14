package com.HuskyGroups.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @OneToMany(mappedBy="topic")
    private Set<Group> items;


}
