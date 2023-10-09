package com.example.securitytest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.securitytest.entity.school.School;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 雨天留恋
 * @date 2023-07-31 9:53
 */
@Mapper
public interface SchoolMapper extends BaseMapper<School> {
}
