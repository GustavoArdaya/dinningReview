package com.codecademy.dinningReview.controller;

import com.codecademy.dinningReview.model.User;
import com.codecademy.dinningReview.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User createUser(@RequestBody User newUser) {
        newUser = this.userRepository.save(newUser);
        return newUser;
    }
}