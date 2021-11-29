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

//			// create a new Topic
//			Topic chem = new Topic();
//			chem.setName("Chemistry");
//			chem.setDescription("practice purpose only!");
//
//			Topic phy = new Topic();
//			phy.setName("Physics");
//			phy.setDescription("practice purpose only!");
//
//			// save the topic
//			topicRepository.save(chem);
//			topicRepository.save(phy);



			// create and save new groups
//			Group g1 = groupRepository.save(new Group("Chem hub","desc1", "links to gc: xxx", chem));
//			Group g2 = groupRepository.save(new Group("Chem McNair Chem Chat ", "desc 2", "Links to gc: xxx", chem));

			User u1 = new User("Xiaojie", "Chen", "xiaojiec@gmail.com");
			userRepository.save(u1);

//			membershipRepository.save(new Membership(u1, g1));

		};
	}
	public static void main(String[] args) {
		SpringApplication.run(HuskyGroupsApplication.class, args);
	}

}
