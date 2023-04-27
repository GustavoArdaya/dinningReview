package com.codecademy.dinningReview.controller;

import com.codecademy.dinningReview.model.Restaurant;
import com.codecademy.dinningReview.repository.RestaurantRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants/")
@CrossOrigin(origins = "*")
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping()
    public List<Restaurant> getAllRestaurants() {
        return this.restaurantRepository.findAll();
    }

    @PostMapping()
    public Restaurant createRestaurant(Restaurant restaurant) {
        if(this.restaurantRepository.findByNameAndZipCodeAllIgnoreCase(restaurant.getName(), restaurant.getZipCode()).isEmpty()) {
            return this.restaurantRepository.save(restaurant);
        }
        throw new RuntimeException("Restaurant with name " + restaurant.getName() + " and zip code " + restaurant.getZipCode() + " already exists");
    }
}
