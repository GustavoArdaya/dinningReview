package com.codecademy.dinningReview.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UdemyTestController {

    //injecting properties from application.properties

    @Value("${admin.name}")
    private String adminName;

    @GetMapping("/admin")
    public String getAdminName() {
        return "Page Admin: " + adminName;
    }
}
