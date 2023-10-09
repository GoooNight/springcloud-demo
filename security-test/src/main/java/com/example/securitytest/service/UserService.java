package com.example.securitytest.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.securitytest.entity.user.User;
import com.example.securitytest.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 雨天留恋
 * @date 2023-07-19 12:51
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    public List<User> getUserList() {
        return baseMapper.selectList(null);
    }

    public boolean addUser(User user) {
        int insert = baseMapper.insert(user);
        return insert > 0;
    }

}
