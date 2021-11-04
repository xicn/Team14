package com.HuskyGroups.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "welcome home!";
    }
}
