package com.example.eurekagatewaydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 雨天留恋
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaGatewayDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaGatewayDemoApplication.class, args);
    }

}
