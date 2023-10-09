package com.example.orderservicedemo.controller;

import com.example.feginapidemo.clients.UserClient;
import com.example.feginapidemo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


/**
 * @author 雨天留恋
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserClient userClient;

    @GetMapping("/getData")
    public Object getData(){
        return restTemplate.getForObject("http://user-service/user/getUsers", Object.class);
    }

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userClient.getUsers();
    }

}
