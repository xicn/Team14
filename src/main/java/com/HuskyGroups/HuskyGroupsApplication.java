package com.HuskyGroups;

import com.HuskyGroups.database.GroupRepository;
import com.HuskyGroups.database.MembershipRepository;
import com.HuskyGroups.database.TopicRepository;
import com.HuskyGroups.database.UserRepository;
import com.HuskyGroups.entity.Group;
import com.HuskyGroups.entity.Membership;
import com.HuskyGroups.entity.Topic;
import com.HuskyGroups.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HuskyGroupsApplication {

	@Bean
	public CommandLineRunner mappingDemo(GroupRepository groupRepository,
										 TopicRepository topicRepository, UserRepository userRepository, MembershipRepository membershipRepository) {
		return args -> {


		};
	}
	public static void main(String[] args) {
		SpringApplication.run(HuskyGroupsApplication.class, args);
	}

}
