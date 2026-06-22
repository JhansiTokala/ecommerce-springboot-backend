package com.jhansi.ecommerce.controller;

import com.jhansi.ecommerce.dto.RegisterRequest;
import com.jhansi.ecommerce.service.UserService;
import org.springframework.web.bind.annotation.*;
import com.jhansi.ecommerce.dto.LoginRequest;
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(
            @RequestBody RegisterRequest request) {

        return userService.register(request);
    }

    @PostMapping("/login")
    public String login(
            @RequestBody LoginRequest request) {

        return userService.login(request);
    }
}