package com.codecademy.dinningReview.repository;

import com.codecademy.dinningReview.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Optional<Restaurant> findByNameAndZipCodeAllIgnoreCase(String name, String zipCode);
}
