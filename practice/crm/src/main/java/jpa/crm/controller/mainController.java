package jpa.crm.controller;

import jpa.crm.entity.User;
import jpa.crm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/com")
public class mainController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/hello")
    public String getUser() {
        return "login success";
    }

    @PostMapping("/register")
    public User addUser(@RequestBody User user) {
        User save = userRepository.save(user);
        return save;
    }
    @GetMapping("/getUsers")
    public List<User> getallUser(){
        return userRepository.findAll();
    }
}
