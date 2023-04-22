package com.codecademy.dinningReview.model;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

public class Review {
    //private List<Rating> ratingList = new ArrayList<>();
    private Long id;
    private String author;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    private Rating peanutRating;
    private Rating eggRating;

    private Rating dairyRating;

    private String commentary;
}
