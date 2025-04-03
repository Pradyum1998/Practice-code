package com.token.jwt.controller;

import com.token.jwt.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {
    private List<Students> studentsList = new ArrayList<>(List.of(new Students(1, "pradyum", 70), new Students(2, "kush", 75)));

    @GetMapping("/students")
    public List<Students> getStudents() {
        return studentsList;
    }
//    this token is require for post, patch, delete methods and we send throught header with key X-CSRF-TOKEN and value as token
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf"); // this _csrf is name of attribute you may find in pageSource in browser
    }
    @PostMapping("/students")
    public Students addStudents(@RequestBody Students students){
        studentsList.add(students);
        return students;
    }

    @Autowired
    UserService userService;
    @PostMapping("/login")
    public String login(@RequestBody Students student){
       return userService.verifyUser(student);
    }
}
