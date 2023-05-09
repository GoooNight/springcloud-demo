package com.example.springsecurityjwt.mvc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.springsecurityjwt.mvc.domain.LoginUser;
import com.example.springsecurityjwt.mvc.domain.User;
import com.example.springsecurityjwt.mvc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author 雨天留恋
 * @date 2023-04-24 13:40
 * 该类在使用表单验证时，会调用该方法，进行数据库比较，密码时查出来进行对比的。
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getName, username));
        user = Optional.ofNullable(user).orElseThrow(() -> new RuntimeException("用户未找到"));
        return LoginUser.builder().user(user).build();
    }
}
