package com.example.testeve.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author 雨天留恋
 */
@Data
// 建造者模式
@Builder
// 链式调用
@Accessors(chain = true)
public class User {
    private String name;
    private Integer id;
    private String email;
    @Singular("course")
    private List<String> list;
}
