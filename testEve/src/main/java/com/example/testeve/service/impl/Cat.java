package com.example.testeve.service.impl;

import com.example.testeve.service.Animal;
import org.springframework.stereotype.Service;

/**
 * @author 雨天留恋
 * @date 2023-06-05 13:54
 */
@Service
public class Cat implements Animal {
    @Override
    public void say() {
        System.out.println("I am a cat.");
    }
}
