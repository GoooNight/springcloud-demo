package com.example.testeve.controller;

import com.example.testeve.service.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 雨天留恋
 * @date 2023-06-05 13:55
 */
@Controller
public class AnimalController {


    @Autowired
    public Animal cat;

    @GetMapping
    @ResponseBody
    public Animal test() {
        cat.say();
        return cat;
    }
}
