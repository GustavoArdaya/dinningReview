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
    public List<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping(("{id}"))
    public User getUserById(@PathVariable Long id) {
        var user = this.userRepository.findById(id);
        if (user.isPresent()) return user.get();
        throw new RuntimeException("Could not find any User with the given id...");
    }



    @GetMapping("search")
    public List<User> findByName(@RequestParam(required = false)String name) {
        var filteredList = this.userRepository.findByNameContainingIgnoreCase(name);
        return filteredList;


    }

    @PutMapping("{id}")
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
