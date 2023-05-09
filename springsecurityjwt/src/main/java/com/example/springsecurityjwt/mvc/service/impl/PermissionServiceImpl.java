package com.example.springsecurityjwt.mvc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecurityjwt.mvc.domain.Permission;
import com.example.springsecurityjwt.mvc.mapper.PermissionMapper;
import com.example.springsecurityjwt.mvc.service.PermissionService;
import com.example.springsecurityjwt.util.R;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 权限(Permission)表服务实现类
 *
 * @author Gooonight
 * @since 2023-05-06 15:24:22
 */
@Slf4j
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {


    @Resource
    private PermissionMapper permissionMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public R queryById(String id) {
        return R.ok().data(this.permissionMapper.queryById(id));
    }

    /**
     * 全查询
     *
     * @param permission 筛选条件
     * @return 查询结果
     */
    @Override
    public R queryAll(Permission permission) {
        return R.ok().data(this.permissionMapper.queryAll(permission));
    }

    /**
     * 模糊全查询
     *
     * @param permission 筛选条件
     * @return 查询结果
     */
    @Override
    public R queryAllLike(Permission permission) {
        return R.ok().data(this.permissionMapper.queryAllLike(permission));
    }

    /**
     * 分页查询
     *
     * @param pageNum    页数
     * @param pageSize   每页数量
     * @param permission 筛选条件
     * @return 查询结果
     */
    @Override
    public R page(int pageNum, int pageSize, Permission permission) {
        return R.ok().data(PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> this.permissionMapper.queryAll(permission)));
    }

    /**
     * 分页模糊查询
     *
     * @param pageNum    页数
     * @param pageSize   每页数量
     * @param permission 筛选条件
     * @return 查询结果
     */
    @Override
    public R pageLike(int pageNum, int pageSize, Permission permission) {
        return R.ok().data(PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> this.permissionMapper.queryAllLike(permission)));
    }

    /**
     * 新增数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public R insert(Permission permission) {
        baseMapper.insert(permission);
        return R.ok().data(permission);
    }

    /**
     * 修改数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public R update(Permission permission) {
        baseMapper.updateById(permission);
        return R.ok().data(this.permissionMapper.queryById(permission.getId()));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @Transactional
    public R deleteById(String id) {
        boolean del = baseMapper.deleteById(id) > 0;
        return R.ok().data(del);
    }
}
