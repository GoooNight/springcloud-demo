package com.example.securitytest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.securitytest.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 雨天留恋
 * @date 2023-07-19 12:50
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
