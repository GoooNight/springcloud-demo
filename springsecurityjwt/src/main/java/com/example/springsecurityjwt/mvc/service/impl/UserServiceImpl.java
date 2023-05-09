package com.example.springsecurityjwt.mvc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecurityjwt.util.JWTUtil;
import com.example.springsecurityjwt.util.PasswordUtil;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import com.example.springsecurityjwt.mvc.domain.User;
import com.example.springsecurityjwt.mvc.mapper.UserMapper;
import com.example.springsecurityjwt.mvc.service.UserService;
import com.example.springsecurityjwt.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 用户表(User)表服务实现类
 *
 * @author Gooonight
 * @since 2023-04-10 19:34:56
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Resource
    private UserMapper userMapper;
    @Autowired
    private PasswordUtil passwordUtil;

    /***
     * @param user:
     * @return R
     * @author 雨天留恋
     * @description TODO 用户查询
     * @date 2023/4/27 13:35
     */
    @Override
    public R queryUser(User user) {
        User selectOne = baseMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getName, user.getName()));
        if (Optional.ofNullable(selectOne).isEmpty()) {
            return R.notFound();
        }
        boolean passwordIsOk = passwordUtil.passwordMatches(user.getPassword(), selectOne.getPassword());
        if (!passwordIsOk) {
            return R.notFound();
        }
        log.info(selectOne.toString());
        String token = JWTUtil.builder().build().creatToken(selectOne);
        return R.loginOk(token).data(selectOne);

    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public R queryById(String id) {
        return R.ok().data(this.userMapper.queryById(id));
    }

    /**
     * 全查询
     *
     * @param user 筛选条件
     * @return 查询结果
     */
    @Override
    public R queryAll(User user) {
        return R.ok().data(this.userMapper.queryAll(user));
    }

    /**
     * 模糊全查询
     *
     * @param user 筛选条件
     * @return 查询结果
     */
    @Override
    public R queryAllLike(User user) {
        return R.ok().data(this.userMapper.queryAllLike(user));
    }

    /**
     * 分页查询
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @param user     筛选条件
     * @return 查询结果
     */
    @Override
    public R page(int pageNum, int pageSize, User user) {
        return R.ok().data(PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> this.userMapper.queryAll(user)));
    }

    /**
     * 分页模糊查询
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @param user     筛选条件
     * @return 查询结果
     */
    @Override
    public R pageLike(int pageNum, int pageSize, User user) {
        return R.ok().data(PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> this.userMapper.queryAllLike(user)));
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public R insert(User user) {
        // User userResult = passwordUtil.passwordEncode(user);
        // baseMapper.insert(userResult);
        return R.ok().data(null);
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public R update(User user) {
       baseMapper.updateById(user);
        return R.ok().data(this.userMapper.queryById(user.getId()));
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
