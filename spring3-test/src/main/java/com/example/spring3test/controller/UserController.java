package com.example.spring3test.controller;

import com.example.spring3test.entity.User;
import org.springframework.boot.actuate.endpoint.web.annotation.ControllerEndpoint;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 雨天留恋
 * @date 2023-06-22 10:46
 */
@RestController
public class UserController {

    @PostMapping("user")
    public User getUser(@Validated @RequestBody User user) {
        System.out.println(user);
        return user;
    }

}
