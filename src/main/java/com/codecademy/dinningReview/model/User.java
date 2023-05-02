package com.codecademy.dinningReview.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "USERS")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(unique=true, updatable = false)
    private String name;
    private String city;
    private String state;
    private String zipCode;
    private Boolean interestedInPeanutAllergies;
    private Boolean interestedInEggAllergies;
    private Boolean interestedInDairyAllergies;
    @OneToMany(mappedBy = "author")
    @JsonManagedReference
    private List<Review> userReviews;

    public void updateUser(User user) {
        String city=user.getCity();
        String state=user.getState();
        String zipCode=user.getZipCode();
        Boolean interestedInPeanutAllergies=user.getInterestedInPeanutAllergies();
        Boolean interestedInEggAllergies=user.getInterestedInEggAllergies();
        Boolean interestedInDairyAllergies=user.getInterestedInDairyAllergies();

        this.city=city!=null ? city : this.city;
        this.state=state!=null ? state : this.state;
        this.zipCode=zipCode!=null ? zipCode : this.zipCode;
        this.interestedInPeanutAllergies=interestedInPeanutAllergies!=null ? interestedInPeanutAllergies : this.interestedInPeanutAllergies;
        this.interestedInEggAllergies=interestedInEggAllergies!=null ? interestedInEggAllergies : this.interestedInEggAllergies;
        this.interestedInDairyAllergies=interestedInDairyAllergies!=null ? interestedInDairyAllergies : this.interestedInDairyAllergies;
    }

}
