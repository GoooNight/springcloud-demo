package com.example.testeve;

import com.example.testeve.service.Animal;
import com.example.testeve.service.impl.Cat;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class TestEveApplicationTests {

    @Resource(name = "cat")
    private Animal animal;

    @Test
    void contextLoads() {
        animal.say();
        System.out.println(AopUtils.isAopProxy(animal));
    }

}
