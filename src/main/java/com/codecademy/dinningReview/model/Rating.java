package com.codecademy.dinningReview.model;

public enum Rating {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);

    public final int stars;

    Rating(int stars) {
        this.stars = stars;
    }



}