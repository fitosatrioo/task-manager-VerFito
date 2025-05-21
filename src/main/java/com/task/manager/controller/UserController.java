package com.task.manager.controller;

import com.task.manager.model.User;
import com.task.manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/getUser")
    public String getUser() {
        return "Hello User";
    }

    
    @PostMapping("/pong")
    public String pong() {
        return "Pong";
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User loginUser) {
        User user = userRepository.findByUserName(loginUser.getUserName());
        if (user != null && user.getPassword().equals(loginUser.getPassword())) {
            return user;
        }
        return null;
    }
}
