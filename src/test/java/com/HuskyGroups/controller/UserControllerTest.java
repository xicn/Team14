package com.HuskyGroups.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserController controller;

    // Test to see if UserController is ready to use
    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }


}
