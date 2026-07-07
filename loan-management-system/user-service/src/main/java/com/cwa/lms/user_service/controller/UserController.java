package com.cwa.lms.user_service.controller;

import com.cwa.lms.user_service.dto.LoginRequest;
import com.cwa.lms.user_service.dto.RegisterRequest;
import com.cwa.lms.user_service.entity.User;
import com.cwa.lms.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/lms/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest loginRequest){
        return userService.login(loginRequest);
    }

    @GetMapping("/users/profile/{id}")
//    @PreAuthorize("hasRole('USER')")
    public Optional<User> getUserProfile(@PathVariable Long id){
        return userService.getUserProfile(id);
    }
}
