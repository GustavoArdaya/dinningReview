package com.codecademy.dinningReview.model;

import lombok.Data;


public enum ReviewStatus {
    PENDING("Pending"),
    APPROVED("Approved"),
    REJECTED("Rejected");

    private final String status;

    ReviewStatus(String status) {
        this.status = status;
    }

    public String getReviewStatus() {
        return status;
    }
}
