package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/com")
public class MainController {
    @GetMapping("/login/{username}/{password}")
    public String loggin(@PathVariable String username, @PathVariable String password, @RequestBody String name) {
        if (username.equals("ram") && password.equals("ram")) {
            return "logged In"+name;
        }
        return "error";
    }
}
