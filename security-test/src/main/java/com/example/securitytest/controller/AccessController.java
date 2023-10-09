package com.example.securitytest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 雨天留恋
 * @date 2023-07-08 15:55
 */
@RestController
public class AccessController {


    @RequestMapping("/errors/access-denied")
    public String accessDenied() {
        return "拒绝访问！";
    }

}
