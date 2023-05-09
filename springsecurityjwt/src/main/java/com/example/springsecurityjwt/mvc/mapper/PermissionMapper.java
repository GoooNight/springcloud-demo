package com.example.springsecurityjwt.mvc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springsecurityjwt.mvc.domain.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限(Permission)表数据库访问层
 *
 * @author Gooonight
 * @since 2023-05-06 15:24:22
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

        /**
         * 通过ID查询单条数据
         *
         * @param id 主键
         * @return 实例对象
         */
        Permission queryById(String id);

        /**
         * 查询指定行数据
         *
         * @param permission 查询条件
         * @return 对象列表
         */
        List<Permission> queryAll(Permission permission);

        /**
         * 模糊查询指定行数据
         *
         * @param permission 查询条件
         * @return 对象列表
         */
        List<Permission> queryAllLike(Permission permission);

        /**
         * 统计总行数
         *
         * @param permission 查询条件
         * @return 总行数
         */
        long count(Permission permission);

        /**
         * 批量新增数据（MyBatis原生foreach方法）
         *
         * @param entities List<Permission> 实例对象列表
         * @return 影响行数
         */
        int insertBatch(@Param("entities") List<Permission> entities);

        /**
         * 批量新增或按主键更新数据（MyBatis原生foreach方法）
         *
         * @param entities List<Permission> 实例对象列表
         * @return 影响行数
         * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
         */
        int insertOrUpdateBatch(@Param("entities") List<Permission> entities);

}

