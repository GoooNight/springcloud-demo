package com.example.userservicedemo.controller;

import com.example.userservicedemo.entity.User;
import com.example.userservicedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;


/**
 * @author 雨天留恋
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getUsers")
    public Flux<User> getUsers() {
        return userService.getUsers();
    }


}
