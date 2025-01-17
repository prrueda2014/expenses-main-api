package com.expenses.main.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/admin")
    public String homeAdmin() {
        return "Welcome! Admin";
    }

    @GetMapping("/user")
    public String homeUser() {
        return "Welcome! User";
    }

}
