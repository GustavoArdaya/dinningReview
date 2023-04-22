package com.codecademy.dinningReview.model;

import jakarta.persistence.*;
import lombok.Data;

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


}
