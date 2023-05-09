package com.example.springsecurityjwt.mvc.service;

import com.example.springsecurityjwt.mvc.domain.Permission;
import com.example.springsecurityjwt.util.R;

/**
 * 权限(Permission)表服务接口
 *
 * @author Gooonight
 * @since 2023-05-06 15:24:22
 */
public interface PermissionService {

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
     * @param permission 筛选条件
     * @return 查询结果
     */
    R queryAll(Permission permission);

    /**
     * 模糊全查询
     *
     * @param permission 筛选条件
     * @return 查询结果
     */
    R queryAllLike(Permission permission);

    /**
     * 分页查询
     *
     * @param pageNum    页数
     * @param pageSize   每页数量
     * @param permission 筛选条件
     * @return 查询结果
     */
    R page(int pageNum, int pageSize, Permission permission);

    /**
     * 分页模糊查询
     *
     * @param pageNum    页数
     * @param pageSize   每页数量
     * @param permission 筛选条件
     * @return 查询结果
     */
    R pageLike(int pageNum, int pageSize, Permission permission);

    /**
     * 新增数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    R insert(Permission permission);

    /**
     * 修改数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    R update(Permission permission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    R deleteById(String id);

}
