package com.example.mysqltest.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 用户(User)表实体类
 *
 * @author Gooonight
 * @since 2023-02-28 20:56:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User implements Serializable {
    private static final long serialVersionUID = 238789841431041790L;

    /**
     * 用户id
     */
    @TableField(value = "id")
    private Integer id;

    /**
     * 用户名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 用户密码
     */
    @TableField(value = "password")
    private String password;


}

