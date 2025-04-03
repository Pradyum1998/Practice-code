package com.app.client.controller;

import com.app.client.service.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
/* in this class we are calling another microservice for get and post operation with the help of rest templete */
@RestController
@RequestMapping("app")
public class Controller {
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("getAllUser")
    public List<User> getUsers(){
        List<User> users = restTemplate.getForEntity("http://localhost:8080/com/getAllUser", List.class).getBody();
        return users;
    }
    @RequestMapping("user/{id}")
    public User getUser(@PathVariable Integer id){
        User user = restTemplate.getForObject("http://localhost:8080/com/user/" + id, User.class);
        return user;
    }
    @PostMapping("addUser")
    public String addUser(@RequestBody User user) {
       restTemplate.postForEntity("http://localhost:8080/com/addUser", user, User.class);
       return "saved successfully";
    }

    /* this code is to check how one topic can be listened by multiple consumer groups */

    @KafkaListener(topics = "DEMO_TOPIC",groupId = "DEMO_GROUP")
    public void consumer(String user){
        System.out.println(user);
    }

    @KafkaListener(topics = "DEMO_TOPIC",groupId = "DEMO_GROUP1")
    public void consumer1(String user){
        System.out.println(user);
    }

    @KafkaListener(topics = "DEMO_TOPIC",groupId = "DEMO_GROUP2")
    public void consumer2(String user){
        System.out.println(user);
    }

    /* as one consumer can listen to multiple topics below is the method which is listening to multiple topics */
        /* here groupId = "DEMO_GROUP3" because this method should not listen to DEMO_TOPIC*/
    @KafkaListener(topics = {"DEMO_TOPIC1","DEMO_TOPIC2","DEMO_TOPIC3"},groupId = "DEMO_GROUP3")
    public void consumer3(String user){
        System.out.println(user);
    }

}
