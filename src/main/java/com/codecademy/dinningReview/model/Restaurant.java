package com.codecademy.dinningReview.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RESTAURANTS")
@Data
public class Restaurant {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id", nullable = false)
private long id;

private String name;

private String cuisine;

private String description;

private String city;

private String state;

private String zipCode;

private Double averageScore;

private Double peanutAllergyScore;

private Double eggAllergyScore;

private Double dairyAllergyScore;

}


