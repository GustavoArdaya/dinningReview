package com.codecademy.dinningReview.service;

import com.codecademy.dinningReview.model.Restaurant;
import com.codecademy.dinningReview.model.Review;
import com.codecademy.dinningReview.model.User;
import com.codecademy.dinningReview.repository.RestaurantRepository;
import com.codecademy.dinningReview.repository.ReviewRepository;
import com.codecademy.dinningReview.repository.UserRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class RestaurantService {

private final RestaurantRepository restaurantRepository;
private final UserRepository userRepository;
private final ReviewRepository reviewRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, UserRepository userRepository, ReviewRepository reviewRepository) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<Restaurant> getAllRestaurants() {
        return this.restaurantRepository.findAll();
    }

    public Optional<Restaurant> getRestaurantById(@PathVariable Long id) {
        return this.restaurantRepository.findById(id);
    }

    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        if (this.restaurantRepository.findByNameAndZipCodeAllIgnoreCase(restaurant.getName(), restaurant.getZipCode()).isEmpty()) {
            return this.restaurantRepository.save(restaurant);
        }
        throw new RuntimeException("Restaurant with name " + restaurant.getName() + " and zip code " + restaurant.getZipCode() + " already exists");
    }

    public Review createReview(@PathVariable Long restaurantId, @PathVariable Long userId, @RequestBody Review review) {
        Restaurant restaurant = this.restaurantRepository.findById(restaurantId).get();
        User user = this.userRepository.findById(userId).get();
        review.setAuthor(user);
        review.setRestaurant(restaurant);
        //restaurant.getRestaurantReviews().add(review);
        return reviewRepository.save(review);
    }
}
