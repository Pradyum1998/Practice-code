package com.example.demo.controller;

import com.example.demo.service.Constants;
import com.example.demo.service.User;
import com.example.demo.service.UserCredentials;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/* in this class we are performing get and post operation in db with the help of hibernate */
@RestController
@RequestMapping("com")
public class MainController {
    public static Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @PostMapping("token")
    public String generateToken(@RequestBody UserCredentials user){
        if (user.getUsername().equals("Admin") && user.getPassword().equals("Admin123")){
            return "valid user please go ahead";
        }
        return "invalid user please try again";
    }
    @Autowired
    UserService userService;
    @GetMapping("user/{id}")
    public User getSingleUserFromId(@PathVariable Integer id) {
        User user = userService.findUserById(id);
        return user;
    }

    @PostMapping("addUser")
    public void addUser(@RequestBody User user) {
        userService.addUserinDb(user);
    }
    @GetMapping("getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUserFromDB();
    }

    @PostMapping("addUseMobile")
    public void addUserWithMobile(@RequestBody User user){
        userService.addUseWithMobileInDB(user);
    }

    /* Kafka coding */

    /*
     go to kafka folder and open cmd and run below commands
     commands to run zookeeper and kafka
     .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
     .\bin\windows\kafka-server-start.bat .\config\server.properties

      simple extracted file were not working so Opened in 7z and copy all folder and files
*/
    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    @PostMapping("producer")
    public void producer(@RequestParam("id") int id) throws JsonProcessingException {
        User user = userService.findUserById(id);
        /* sending user in the form of json */
        String value = getStringFromUser(user);
        kafkaTemplate.send(Constants.TOPIC,value);
    }

    private static String getStringFromUser(User user) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(user);
        return value;
    }

    @PostMapping("producer1")
    public void producer1(@RequestParam("id") int id) throws JsonProcessingException {
        User user = userService.findUserById(id);
        kafkaTemplate.send(Constants.TOPIC1,getStringFromUser(user));
    }
    @PostMapping("producer2")
    public void producer2(@RequestParam("id") int id) throws JsonProcessingException {
        User user = userService.findUserById(id);
        kafkaTemplate.send(Constants.TOPIC2,getStringFromUser(user));
    }
    @PostMapping("producer3")
    public void producer3(@RequestParam("id") int id) throws JsonProcessingException {
        User user = userService.findUserById(id);
        kafkaTemplate.send(Constants.TOPIC3,getStringFromUser(user));
    }
}

