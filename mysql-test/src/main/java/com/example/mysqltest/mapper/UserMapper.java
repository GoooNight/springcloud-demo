package com.example.mysqltest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mysqltest.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 用户(User)表数据库访问层
 *
 * @author Gooonight
 * @since 2023-02-28 20:56:58
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}


