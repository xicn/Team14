package com.HuskyGroups.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Topic {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "uuid2"
    )
    @Column(name = "Topic_ID", updatable = false, nullable = false, length = 16)
    private UUID activityID;
    @Column(columnDefinition = "TINYTEXT")
    private String name;
    @Column(columnDefinition = "TINYTEXT")
    private String description;


}
