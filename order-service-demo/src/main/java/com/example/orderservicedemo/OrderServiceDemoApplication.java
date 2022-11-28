package com.example.orderservicedemo;

import com.example.feginapidemo.clients.UserClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author 雨天留恋
 */
@SpringBootApplication
@EnableFeignClients(clients={UserClient.class})
public class OrderServiceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceDemoApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
