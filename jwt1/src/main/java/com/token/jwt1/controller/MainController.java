package com.token.jwt1.controller;

import com.token.jwt1.service.JwtService;
import com.token.jwt1.service.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {
    @Autowired
    JwtService jwtService;

    @PostMapping("login")
    public String login(@RequestBody User user) {
        return jwtService.generateToken(user);
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User("pradyum"));
        users.add(new User("Ram"));
        return users;
    }
}
