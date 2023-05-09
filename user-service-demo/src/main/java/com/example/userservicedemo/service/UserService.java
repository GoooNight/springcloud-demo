package com.example.userservicedemo.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.userservicedemo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 雨天留恋
 */
@Service
@Slf4j
public class UserService {

    @Value("${server.port}")
    private String port;

    public Flux<User> getUsers() {
        User user = User.builder().id(125554L).userName("小明").age(18).userName("8555sd555").email("1215555").build();
        User user1 = User.builder().id(125554L).userName("小明").age(18).userName("8555sd555").email("1215555").build();
        User user2 = User.builder().id(125554L).userName("小明").age(18).userName("8555sd555").email("1215555").build();
        User user3 = User.builder().id(125554L).userName("小明").age(18).userName("8555sd555").email("1215555").build();
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        log.info(port);
        return Flux.fromIterable(userList);
    }

    /**
     * 为该方法添加sentinel监控的注解
      */
    @SentinelResource("resource")
    public void resource() {
        System.out.println("UserService.resource");
    }
}
