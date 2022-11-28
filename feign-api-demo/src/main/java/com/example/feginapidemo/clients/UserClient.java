package com.example.feginapidemo.clients;

import com.example.feginapidemo.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author 雨天留恋
 */
@FeignClient("user-service")
public interface UserClient {

    @GetMapping("user/getUsers")
    List<User> getUsers();
}
