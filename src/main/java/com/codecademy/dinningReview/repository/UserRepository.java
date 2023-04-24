package com.codecademy.dinningReview.repository;

import com.codecademy.dinningReview.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
