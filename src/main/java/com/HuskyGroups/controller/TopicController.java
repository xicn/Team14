package com.HuskyGroups.controller;


import com.HuskyGroups.entity.Topic;
import com.HuskyGroups.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/getTopics")
    public List<Topic> getTopic() {
        return topicService.getAll();
    }
}
