package com.example.userservicedemo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * @author 雨天留恋
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@SuperBuilder
public class User extends FatherEntity{
    private String name;
    private String password;
    private String userName;
    private String email;
    private Date birthDate;
    private Integer age;
    private Integer sex;

}
