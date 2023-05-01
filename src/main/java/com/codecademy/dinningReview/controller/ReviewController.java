package com.codecademy.dinningReview.controller;

import com.codecademy.dinningReview.model.Restaurant;
import com.codecademy.dinningReview.model.Review;
import com.codecademy.dinningReview.model.User;
import com.codecademy.dinningReview.repository.RestaurantRepository;
import com.codecademy.dinningReview.repository.ReviewRepository;
import com.codecademy.dinningReview.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@CrossOrigin(origins = "*")
public class ReviewController {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    public ReviewController(ReviewRepository reviewRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

}
