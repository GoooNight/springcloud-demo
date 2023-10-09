package com.example.securitytest.controller;

import com.example.securitytest.entity.user.User;
import com.example.securitytest.service.UserService;
import com.example.securitytest.utils.ResultResponse;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.refresh.ConfigDataContextRefresher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @author 雨天留恋
 * @date 2023-07-08 10:03
 */
@RestController
public class UserController {

    // @Resource
    // private KafkaTemplate<String,String> kafkaTemplate;
    @Autowired
    private UserService userService;

    // @GetMapping("/user/getUserList")
    // @PreAuthorize(value = "hasAuthority('USER')")
    // public ResultResponse getUserList() {
    //     User user01 = User.builder().id("1").name("小花").password("222").build();
    //     User user02 = User.builder().id("2").name("小红").password("333").build();
    //     List<User> userList = new ArrayList<>(8);
    //     userList.add(user01);
    //     userList.add(user02);
    //     return ResultResponse.ok(userList);
    // }

    @GetMapping("login_success")
    public ResultResponse login(String username, String password) {

        if ("小红".equals(username) && "12345".equals(password)) {
            return ResultResponse.ok("登陆成功");
        }else {
            return ResultResponse.badRequest("用户名密码错误");
        }

    }
    @GetMapping("/user/getUserList")
    public ResultResponse getUserList() {
        List<User> userList = userService.getUserList();
        return ResultResponse.ok(userList);
    }

    @PostMapping("/user/addUser")
    public ResultResponse addUser(@RequestBody User user) {
        boolean b = userService.addUser(user);
        if(b){
            return ResultResponse.ok(b);
        }
            return ResultResponse.badRequest(b);
    }


}
