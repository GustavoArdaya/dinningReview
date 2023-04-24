package com.codecademy.dinningReview.repository;

import com.codecademy.dinningReview.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
