package com.token.jwt.service;

import com.token.jwt.controller.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtService jwtService;
    public String verifyUser(Students student){
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(student.getName(),"kush123"));
        if (authenticate.isAuthenticated())
            return jwtService.generateToken(student.getName());

        return "fail";
    }
}
