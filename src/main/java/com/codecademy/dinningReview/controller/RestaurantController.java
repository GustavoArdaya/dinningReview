package com.codecademy.dinningReview.controller;

import com.codecademy.dinningReview.model.Restaurant;
import com.codecademy.dinningReview.model.Review;
import com.codecademy.dinningReview.model.User;
import com.codecademy.dinningReview.repository.RestaurantRepository;
import com.codecademy.dinningReview.repository.ReviewRepository;
import com.codecademy.dinningReview.repository.UserRepository;
import com.codecademy.dinningReview.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants/")
@CrossOrigin(origins = "*")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantRepository restaurantRepository, UserRepository userRepository, ReviewRepository reviewRepository, RestaurantService restaurantService) {

        this.restaurantService = restaurantService;
    }

    @GetMapping()
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        List<Restaurant> restaurants = this.restaurantService.getAllRestaurants();
    return ResponseEntity.ok(restaurants);
    }

    @GetMapping("{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        if (id == null) return ResponseEntity.badRequest().header("Id path variable must be present and valid").build();
        Restaurant restaurant =this.restaurantService.getRestaurantById(id);
        if (restaurant == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(restaurant);
    }

    @PostMapping()
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant newRestaurant = this.restaurantService.createRestaurant(restaurant);
        return ResponseEntity.ok(newRestaurant);
    }

    /*@GetMapping("{restaurantId}/reviews")
    public List<Review> getAllRestaurantReviews(@PathVariable Long restaurantId) {
        Restaurant restaurant = this.restaurantRepository.findById(restaurantId).get();
        return restaurant.getRestaurantReviews();
    }*/

    @PostMapping ("{restaurantId}/reviews/{userId}")
    public ResponseEntity<Review> createReview(@PathVariable Long restaurantId, @PathVariable Long userId, @RequestBody Review review) {

        Review newReview = this.restaurantService.createReview(restaurantId, userId, review);
        return ResponseEntity.ok(newReview);
    }

}
