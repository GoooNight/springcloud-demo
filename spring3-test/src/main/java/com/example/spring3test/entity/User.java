package com.example.spring3test.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author 雨天留恋
 * @date 2023-06-22 10:43
 */
@Data
public class User {


    @NotBlank(message = "uid不能为空！")
    private String uid;

    @NotBlank(message = "name不能为空！")
    private String name;



}
