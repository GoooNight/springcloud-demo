package com.example.testeve.service.impl;

import com.example.testeve.service.Animal;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;

/**
 * @author 雨天留恋
 * @date 2023-06-05 13:54
 */
@Service()
public class Dog implements Animal{

    private String beanName;

    public String getBeanName() {
        return this.beanName;
    }
    @Override
    public void say() {
        System.out.println("I am a dog.");
    }

    // @Override
    // public void setBeanName(String beanName) {
    //     this.beanName = beanName;
    //     System.out.println(beanName);
    // }
}
