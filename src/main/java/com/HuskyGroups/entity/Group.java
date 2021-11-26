package com.HuskyGroups.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name="Topic_ID", nullable=false)
    private Topic topic;


}
