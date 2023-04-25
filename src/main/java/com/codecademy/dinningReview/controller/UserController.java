package com.codecademy.dinningReview.controller;

import com.codecademy.dinningReview.model.User;
import com.codecademy.dinningReview.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    private List<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping(("/users/{id}"))
    public User getUserById(Long id) {
        var user = this.userRepository.findById(id);
        if (user.isPresent()) return user.get();
        throw new RuntimeException("Could not find any User with the given id...");
    }

    @PutMapping("/users/{id}")
    public User updateUserById(@PathVariable Long id, @RequestBody User user) {
        var updatedUser = getUserById(id);
        updatedUser.updateUser(user);
        userRepository.save(updatedUser);
        return updatedUser;
    }

    @PostMapping
    public User createUser(@RequestBody User newUser) {
        newUser = this.userRepository.save(newUser);
        return newUser;
    }
}
