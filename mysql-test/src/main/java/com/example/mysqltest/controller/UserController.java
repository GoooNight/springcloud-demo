package com.example.mysqltest.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mysqltest.entity.User;
import com.example.mysqltest.service.UserService;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 用户(User)表控制层
 *
 * @author Gooonight
 * @since 2023-02-28 20:56:36
 */
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param user 查询实体
     * @return 所有数据
     */
    @GetMapping("/page")
    @ApiOperation(value = "分页", notes = "传入param与query")
    public R<IPage<User>> page(@ApiIgnore @RequestParam Map<String, Object> param, Query query) {
        IPage<User> pages = userService.page(Condition.getPage(query), Condition.getQueryWrapper(param, Blog.class));
        return R.data(pages);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/getInfoById")
    @ApiOperation(value = "根据id查询数据", notes = "传入id")
    public R selectOne(@RequestParam(value = "id") Long id) {
        return R.data(userService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 新增结果
     */
    @PostMapping("/insert")
    @ApiOperation(value = "新增", notes = "传入User")
    public R insert(@RequestBody User user) {
        return R.status(userService.save(user));
    }

    /**
     * 修改数据
     *
     * @param user 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改", notes = "传入User")
    public R update(@RequestBody User user) {
        return R.status(userService.updateById(user));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("/remove")
    @ApiOperation(value = "逻辑删除", notes = "传入idList")
    public R delete(@RequestParam("idList") List<Long> idList) {
        return R.status(userService.removeByIds(idList));
    }
}
