package com.codecademy.dinningReview.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    @JsonBackReference
    private User author;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id")
    @JsonBackReference
    private Restaurant restaurant;
    @Enumerated(EnumType.ORDINAL)
    private Rating peanutRating;
    @Enumerated(EnumType.ORDINAL)
    private Rating eggRating;
    @Enumerated(EnumType.ORDINAL)

    private Rating dairyRating;

    private String commentary;

    private Boolean approved = false;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255) default 'PENDING'")
    private ReviewStatus status = ReviewStatus.PENDING;
}
