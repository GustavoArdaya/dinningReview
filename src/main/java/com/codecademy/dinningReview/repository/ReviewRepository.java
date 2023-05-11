package com.codecademy.dinningReview.repository;
import com.codecademy.dinningReview.model.Review;
import com.codecademy.dinningReview.model.ReviewStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {


    List<Review> findByStatusIs(ReviewStatus reviewStatus);
}
