package com.example.nacosdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 雨天留恋
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosDemoApplication.class, args);
    }

}
