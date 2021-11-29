package com.HuskyGroups.controller;


import com.HuskyGroups.entity.Topic;
import com.HuskyGroups.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;





}
