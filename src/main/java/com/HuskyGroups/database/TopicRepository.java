package com.HuskyGroups.database;

import com.HuskyGroups.entity.Topic;
import com.HuskyGroups.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TopicRepository extends JpaRepository<Topic, UUID> {
    Topic findByName(String name);
}
