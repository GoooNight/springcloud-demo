package com.example.springsecurityjwt.mvc.service;

import com.example.springsecurityjwt.mvc.domain.User;
import com.example.springsecurityjwt.util.R;

/**
 * 用户表(User)表服务接口
 *
 * @author Gooonight
 * @since 2023-04-10 19:34:56
 */
public interface UserService {

    R queryUser(User user);


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    R queryById(String id);


    /**
     * 全查询
     *
     * @param user 筛选条件
     * @return 查询结果
     */
    R queryAll(User user);

    /**
     * 模糊全查询
     *
     * @param user 筛选条件
     * @return 查询结果
     */
    R queryAllLike(User user);

    /**
     * 分页查询
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @param user     筛选条件
     * @return 查询结果
     */
    R page(int pageNum, int pageSize, User user);

    /**
     * 分页模糊查询
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @param user     筛选条件
     * @return 查询结果
     */
    R pageLike(int pageNum, int pageSize, User user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    R insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    R update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    R deleteById(String id);

}
