package com.example.springsecurityjwt.mvc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import com.example.springsecurityjwt.mvc.domain.User;
import com.example.springsecurityjwt.mvc.service.UserService;
import com.example.springsecurityjwt.util.R;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 用户表(User)表控制层
 *
 * @author Gooonight
 * @since 2023-04-10 19:34:55
 */
@Slf4j
@RestController
@RequestMapping("user")
@Api(tags = "用户表(User)表控制层")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /***
     * @param user:
     * @return R
     * @author 雨天留恋
     * @description TODO 登录
     * @date 2023/4/27 13:40
     */
    @PostMapping("/login")
    public R login(@RequestBody User user) {
        log.info("登录");
        return userService.queryUser(user);
    }

    /**
     * 全查询
     *
     * @param user 筛选条件
     * @return 查询结果
     */
    @ApiOperation("全查询")
    @GetMapping
    @PreAuthorize(value = "@ex.hasAuthority('1')")
    public R queryAll(@ApiParam(value = "user 筛选条件") User user) {
        log.info("------进来了--------");
        return this.userService.queryAll(user);
    }

    /**
     * 模糊全查询
     *
     * @param user 筛选条件
     * @return 查询结果
     */
    @ApiOperation("模糊全查询")
    @PostMapping("like")
    public R queryAllLike(@ApiParam(value = "user 筛选条件") User user) {
        return this.userService.queryAllLike(user);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("{id}")
    public R queryById(@ApiParam(value = "id 主键") @PathVariable("id") String id) {
        return this.userService.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @param user     筛选条件
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @PostMapping("page")
    public R page(@ApiParam(value = "页数，不传默认是第一页") @RequestParam(defaultValue = "1") int pageNum, @ApiParam(value =
            "每页数量，不传默认是10个") @RequestParam(defaultValue = "10") int pageSize,
                  @ApiParam(value = "user 筛选条件") @RequestBody User user) {
        return this.userService.page(pageNum, pageSize, user);
    }

    /**
     * 分页模糊查询
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @param user     筛选条件
     * @return 查询结果
     */
    @ApiOperation("分页模糊查询")
    @PostMapping("page/like")
    public R pageLike(@ApiParam(value = "页数，不传默认是第一页") @RequestParam(defaultValue = "1") int pageNum,
                      @ApiParam(value = "每页数量，不传默认是10个") @RequestParam(defaultValue = "10") int pageSize,
                      @ApiParam(value = "user 筛选条件") @RequestBody User user) {
        return this.userService.pageLike(pageNum, pageSize, user);
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping
    public R add(@Validated @ApiParam(value = "user 实体") @RequestBody User user) {
        System.out.println(user);
        return this.userService.insert(user);
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @ApiOperation("编辑数据")
    @PutMapping
    public R edit(@ApiParam(value = "user 实体") @RequestBody User user) {
        return this.userService.update(user);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @ApiOperation("删除数据")
    @DeleteMapping
    public R deleteById(@ApiParam(value = "id 主键") @RequestParam String id) {
        return this.userService.deleteById(id);
    }

}

