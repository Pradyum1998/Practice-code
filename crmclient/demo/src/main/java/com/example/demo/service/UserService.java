package com.example.demo.service;

import com.example.demo.repo.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    UserRepository userRepo;
    public void addUserinDb(User user) {
        userRepo.save(user);
    }

    public List<User> getAllUserFromDB() {
        return userRepo.findAll();
    }

    public User findUserById(Integer id) {
        Optional<User> user = userRepo.findById(id);
         return user.get();
    }

    @Transactional
    public void addUseWithMobileInDB(User user) {
        if (user.getUserMobiles() != null){
            user.getUserMobiles().forEach(mobile -> mobile.setUser(user));
        }
        userRepo.save(user);
    }
}
