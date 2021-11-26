package com.HuskyGroups;

import com.HuskyGroups.database.GroupRepository;
import com.HuskyGroups.database.TopicRepository;
import com.HuskyGroups.entity.Group;
import com.HuskyGroups.entity.Topic;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HuskyGroupsApplication {

	@Bean
	public CommandLineRunner mappingDemo(GroupRepository groupRepository,
										 TopicRepository topicRepository) {
		return args -> {

			// create a new Topic
			Topic chem = new Topic();
			chem.setName("Chemistry");
			chem.setDescription("practice purpose only!");

			Topic phy = new Topic();
			phy.setName("Physics");
			phy.setDescription("practice purpose only!");

			// save the topic
			topicRepository.save(chem);
			topicRepository.save(phy);



			// create and save new groups
			groupRepository.save(new Group("Chem hub","desc1", "links to gc: xxx", chem));
			groupRepository.save(new Group("Chem McNair Chem Chat ", "desc 2", "Links to gc: xxx", chem));
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(HuskyGroupsApplication.class, args);
	}

}
