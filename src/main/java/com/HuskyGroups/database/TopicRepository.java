package com.HuskyGroups.database;

import com.HuskyGroups.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TopicRepository extends JpaRepository<Topic, UUID> {
}
