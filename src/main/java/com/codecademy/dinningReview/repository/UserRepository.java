package com.codecademy.dinningReview.repository;

import com.codecademy.dinningReview.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNameContainingIgnoreCase (String name);

}
