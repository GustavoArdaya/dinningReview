package com.codecademy.dinningReview.controller;

import com.codecademy.dinningReview.model.Review;
import com.codecademy.dinningReview.repository.RestaurantRepository;
import com.codecademy.dinningReview.repository.ReviewRepository;
import com.codecademy.dinningReview.repository.UserRepository;
import com.codecademy.dinningReview.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {
    private final ReviewService reviewService;


    public ReviewController(ReviewRepository reviewRepository, UserRepository userRepository, RestaurantRepository restaurantRepository, ReviewService reviewService) {

        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> findAllReviews() {
        List<Review> reviewList = this.reviewService.getAllReviews();
        return ResponseEntity.ok(reviewList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> findReviewById(@PathVariable Long id) {
        Review review = this.reviewService.getReviewById(id);
        return ResponseEntity.ok(review);
    }

    @GetMapping("/pending/")
    public ResponseEntity<List<Review>> findAllApprovalPendingReviews() {
        List<Review> approvalList = this.reviewService.getApprovalPendingReviews();
        return ResponseEntity.ok(approvalList);
    }

    @PutMapping("/pending/{id}")
    public ResponseEntity<Review> approveReviewById(@PathVariable Long id) {
        Review review = this.reviewService.ApproveReviewById(id);
        return ResponseEntity.ok(review);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Review> deleteReviewById(@PathVariable Long id) {
        Review review = this.reviewService.deleteReviewById(id);
        return ResponseEntity.ok(review);

    }

}
