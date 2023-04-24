package com.codecademy.dinningReview.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(unique=true)
    private String name;
    private String city;
    private String state;
    private String zipCode;
    private Boolean interestedInPeanutAllergies;
    private Boolean interestedInEggAllergies;
    private Boolean interestedInDairyAllergies;

}
