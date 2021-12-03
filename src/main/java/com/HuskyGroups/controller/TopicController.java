package com.HuskyGroups.controller;


import com.HuskyGroups.entity.Topic;
import com.HuskyGroups.entity.TopicDTO;
import com.HuskyGroups.entity.User;
import com.HuskyGroups.entity.UserDTO;
import com.HuskyGroups.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping("/createTopic")
    public Topic createTopic(@RequestBody Topic topic) {
        return topicService.saveTopic(topic);
    }

    @GetMapping("/getAllTopics")
    public List<TopicDTO> findAllTopics() {
        List<Topic> topics = topicService.getTopics();
        List<TopicDTO> toReturn = new ArrayList<>();
        for (Topic u: topics) {
            toReturn.add(new TopicDTO(u));
        }
        return toReturn;
    }

    @GetMapping("/getById/{strId}")
    public TopicDTO getTopic(@PathVariable String strId) {
//        System.out.println(strId);
        UUID id = UUID.fromString(strId);
//        System.out.println(id);
        Topic topic = topicService.getTopicByID(id);
        return new TopicDTO(topic);
    }

    @DeleteMapping("/deleteById/{strId}")
    public String deleteTopic(@PathVariable String strId) {
        UUID id = UUID.fromString(strId);
        return topicService.deleteTopic(id);
    }

    @PutMapping("/update")
    public TopicDTO updateUser(@RequestBody TopicDTO topic) {
        Topic toSave = topicService.getTopicByID(UUID.fromString(topic.getTopicID()));
        toSave.setDescription(topic.getDescription());
        toSave.setName(topic.getName());

        return new TopicDTO(topicService.updateUser(toSave));
    }



}
