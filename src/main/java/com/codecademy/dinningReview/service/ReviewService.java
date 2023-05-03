package com.codecademy.dinningReview.service;

import com.codecademy.dinningReview.model.Review;
import com.codecademy.dinningReview.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return this.reviewRepository.findAll();
    }

    public Review getReviewById(Long id) {
        if (this.reviewRepository.findById(id).isPresent()) {
        return this.reviewRepository.findById(id).get();
        }
        throw new RuntimeException("Could not find review");
    }

    public List<Review> getApprovalPendingReviews() {
        return this.reviewRepository.findByApprovedFalse();
    }

    public Review ApproveReviewById(Long id) {
        Review review = this.getReviewById(id);
        review.setApproved(true);
        return review;
    }
}
