package com.example.mysqltest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mysqltest.mapper.UserMapper;
import com.example.mysqltest.entity.User;
import com.example.mysqltest.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户(User)表服务实现类
 *
 * @author Gooonight
 * @since 2023-02-28 20:56:52
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}


