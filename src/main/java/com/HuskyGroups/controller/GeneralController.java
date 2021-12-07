package com.HuskyGroups.controller;

import com.HuskyGroups.entity.AuthRequest;
import com.HuskyGroups.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Collections;
import java.util.Map;

@CrossOrigin
@RestController
public class GeneralController {
//    @GetMapping("/user")
//    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
//        return Collections.singletonMap("name", principal.getAttribute("name"));
//    }
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/Hello")
    @RolesAllowed("USER")
    public String Hello() {
        return "Hello World!";
    }

    @GetMapping("/")
    public String welcome() {
        return "Welcome to HuskyGroup!!";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}
