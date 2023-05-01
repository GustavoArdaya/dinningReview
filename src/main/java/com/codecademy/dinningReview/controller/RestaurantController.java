package com.codecademy.dinningReview.controller;

import com.codecademy.dinningReview.model.Restaurant;
import com.codecademy.dinningReview.model.Review;
import com.codecademy.dinningReview.model.User;
import com.codecademy.dinningReview.repository.RestaurantRepository;
import com.codecademy.dinningReview.repository.ReviewRepository;
import com.codecademy.dinningReview.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants/")
@CrossOrigin(origins = "*")
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    private final ReviewRepository reviewRepository;

    public RestaurantController(RestaurantRepository restaurantRepository, UserRepository userRepository, ReviewRepository reviewRepository) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
    }

    @GetMapping()
    public List<Restaurant> getAllRestaurants() {
        return this.restaurantRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable Long id) {
        return this.restaurantRepository.findById(id);
    }

    @PostMapping()
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        if (this.restaurantRepository.findByNameAndZipCodeAllIgnoreCase(restaurant.getName(), restaurant.getZipCode()).isEmpty()) {
            return this.restaurantRepository.save(restaurant);
        }
        throw new RuntimeException("Restaurant with name " + restaurant.getName() + " and zip code " + restaurant.getZipCode() + " already exists");
    }

    @GetMapping("{restaurantId}/reviews")
    public List<Review> getAllRestaurantReviews(@PathVariable Long restaurantId) {
        Restaurant restaurant = this.restaurantRepository.findById(restaurantId).get();
        return restaurant.getRestaurantReviews();
    }

    @PostMapping ("{restaurantId}/reviews/{userId}")
    public Review createReview(@PathVariable Long restaurantId, @PathVariable Long userId, @RequestBody Review review) {
        Restaurant restaurant = this.restaurantRepository.findById(restaurantId).get();
        User user = this.userRepository.findById(userId).get();
        review.setAuthor(user);
        review.setRestaurant(restaurant);
        //restaurant.getRestaurantReviews().add(review);
        return reviewRepository.save(review);
    }

}
