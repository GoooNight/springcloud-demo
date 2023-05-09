package com.example.gradledemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 雨天留恋
 * @date 2023-04-17 13:17
 */
@RestController
public class UserController {

    @GetMapping
    public String print() {
        return "你好";
    }


}
