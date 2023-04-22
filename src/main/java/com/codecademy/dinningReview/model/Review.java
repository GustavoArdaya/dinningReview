package com.codecademy.dinningReview.model;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Table(name = "reviews")
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
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
