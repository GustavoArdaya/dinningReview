package com.codecademy.dinningReview.model;

public enum Rating {
    ONE(1.0), TWO(2.0), THREE(3.0), FOUR(4.0), FIVE(5.0);

    public final Double stars;

    Rating(Double stars) {
        this.stars = stars;
    }



}