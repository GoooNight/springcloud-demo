package com.example.testeve.controller;

import com.example.testeve.entity.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 雨天留恋
 * @date 2023-05-05 17:10
 */
@RestController
@ResponseBody
@RequestMapping("user")
public class UserController {


    @PostMapping
    public String add(@Validated User user) {
        System.out.println(user);
        return "成功";
    }
}
