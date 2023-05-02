package com.codecademy.dinningReview.service;

import com.codecademy.dinningReview.model.User;
import com.codecademy.dinningReview.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Long id) {
        if (this.userRepository.findById(id).isPresent()) {
        return this.userRepository.findById(id).get();
    }
        throw new RuntimeException("User not found");
    }
}
