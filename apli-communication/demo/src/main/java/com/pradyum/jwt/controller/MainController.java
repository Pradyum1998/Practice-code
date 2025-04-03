package com.pradyum.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {
    @GetMapping(path = "/hello-world/{id}")
    public String getUser(@PathVariable String id){

        List list = new ArrayList();
        return "HELLO "+id.toUpperCase()+" GOOD MORNING!!!!";

    }
}
