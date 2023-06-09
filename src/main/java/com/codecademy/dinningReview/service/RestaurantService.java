package com.codecademy.dinningReview.service;

import com.codecademy.dinningReview.model.Restaurant;
import com.codecademy.dinningReview.model.Review;
import com.codecademy.dinningReview.model.User;
import com.codecademy.dinningReview.repository.RestaurantRepository;
import com.codecademy.dinningReview.repository.ReviewRepository;
import com.codecademy.dinningReview.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RestaurantService {

private final RestaurantRepository restaurantRepository;
private final AuthService authService;
private final ReviewRepository reviewRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, UserRepository userRepository, AuthService authService, ReviewRepository reviewRepository) {
        this.restaurantRepository = restaurantRepository;
        this.authService = authService;

        this.reviewRepository = reviewRepository;
    }

    public List<Restaurant> getAllRestaurants() {
        return this.restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(@PathVariable Long id) {
        Optional<Restaurant> restaurant = this.restaurantRepository.findById(id);
        if(restaurant.isPresent()) {
            return restaurant.get();
        }
        throw new RuntimeException("Could not find restaurant with given id");
    }

    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        if (this.restaurantRepository.findByNameAndZipCodeAllIgnoreCase(restaurant.getName(), restaurant.getZipCode()).isEmpty()) {
            return this.restaurantRepository.save(restaurant);
        }
        throw new RuntimeException("Restaurant with name " + restaurant.getName() + " and zip code " + restaurant.getZipCode() + " already exists");
    }

    public Review createReview(@PathVariable Long restaurantId, @PathVariable Long userId, @RequestBody Review review) {
        if (this.restaurantRepository.findById(restaurantId).isPresent()) {
        Restaurant restaurant = this.restaurantRepository.findById(restaurantId).get();
        User user = this.authService.getUser(userId);
        review.setAuthor(user);
        review.setRestaurant(restaurant);
        //restaurant.getRestaurantReviews().add(review);
        return reviewRepository.save(review);
        }
        throw new RuntimeException("Could not find restaurant");
    }

    /*public List<Review> getAllRestaurantReviews(Long restaurantId) {
        if (this.restaurantRepository.findById(restaurantId).isPresent()) {

        }
    }*/
}
