package com.HuskyGroups;

import com.HuskyGroups.database.GroupRepository;
import com.HuskyGroups.database.TopicRepository;
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
			Topic topic = new Topic();
			topic.setName("xiaojiec");
			topic.setDescription("practice purpose only!");

			// save the book
			topicRepository.save(topic);

			// create and save new pages
//			pageRepository.save(new Page(1, "Introduction contents", "Introduction", book));
//			pageRepository.save(new Page(65, "Java 8 contents", "Java 8", book));
//			pageRepository.save(new Page(95, "Concurrency contents", "Concurrency", book));
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(HuskyGroupsApplication.class, args);
	}

}
