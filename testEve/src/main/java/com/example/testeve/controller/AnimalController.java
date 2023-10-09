package com.example.testeve.controller;

import com.example.testeve.service.Animal;
import com.example.testeve.service.impl.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author 雨天留恋
 * @date 2023-06-05 13:55
 */
@Controller
public class AnimalController {



    // @Autowired
    // public Animal cat;

    // @Resource
    // private List<Animal> animals;
    @Resource
    private Map<String, Animal> animals;


    @GetMapping
    @ResponseBody
    public void test() {
        System.out.println(animals.size());
        animals.forEach((key, value) -> value.say());
    }
}
