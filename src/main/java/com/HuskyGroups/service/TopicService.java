package com.HuskyGroups.service;

import com.HuskyGroups.database.TopicRepository;

import com.HuskyGroups.entity.Topic;
import com.HuskyGroups.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    // Create
    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic);
    }
    public List<Topic> saveTopics(List<Topic> topics) {
        return topicRepository.saveAll(topics);
    }

    // Read
    public List<Topic> getTopics() {
        return topicRepository.findAll();
    }
    public Topic getTopicByID(UUID id) {
        return topicRepository.findById(id).orElse(null);
    }
    public Topic getTopicByName(String name) {
        return topicRepository.findByName(name);
    }

    // Delete
    public String deleteTopic(UUID id) {
        topicRepository.deleteById(id);
        return "Topic deleted!! " + id;
    }

    // Update
    public Topic updateUser(Topic topic) {
        Topic existingTopic = topicRepository.findById(topic.getTopicID()).orElse(null);
        existingTopic.setName(topic.getName());
        existingTopic.setDescription(topic.getDescription());
        return topicRepository.save(existingTopic);
    }

}
