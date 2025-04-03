package com.token.jwt02.controller;

import com.token.jwt02.service.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @PostMapping("/login")
    public String login(@RequestBody User user){

        return "";
    }
}
