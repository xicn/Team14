package com.HuskyGroups.service;

import com.HuskyGroups.database.TopicRepository;

import com.HuskyGroups.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAll() {
        return topicRepository.findAll();
    }
}
