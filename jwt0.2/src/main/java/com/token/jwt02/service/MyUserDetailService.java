package com.token.jwt02.service;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    MyUserDetails myUserDetails;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return myUserDetails;
    }
}
