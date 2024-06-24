package com.example.jediscache.controller;

import com.example.jediscache.entity.User;
import com.example.jediscache.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    @GetMapping("/users/{id}")
    public User getUserEmail(@PathVariable Long id){
        return userService.getUser(id);
    }
}
