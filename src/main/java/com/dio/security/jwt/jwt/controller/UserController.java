package com.dio.security.jwt.jwt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.security.jwt.jwt.model.User;
import com.dio.security.jwt.jwt.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService service;

    @PostMapping
    public void postUser(@RequestBody User user) {
        service.createUser(user);
    }

    @GetMapping
    public void findAllUsers() {
        service.findAllUsers();
    }
}
