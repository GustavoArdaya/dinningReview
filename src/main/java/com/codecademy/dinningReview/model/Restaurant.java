package com.codecademy.dinningReview.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "restaurants")
@Data
public class Restaurant {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id", nullable = false)
private long id;

private String name;

private String cuisine;

private String description;

private Double averageScore;

private Double peanutAllergyScore;

private Double eggAllergyScore;

private Double dairyAllergyScore;
@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name = "reviews")
private List<Review> restaurantReviews;
}
