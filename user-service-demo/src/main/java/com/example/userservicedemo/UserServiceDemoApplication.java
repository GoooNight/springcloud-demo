package com.example.userservicedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 雨天留恋
 */
@SpringBootApplication
@EnableEurekaClient
public class UserServiceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceDemoApplication.class, args);
    }

}
