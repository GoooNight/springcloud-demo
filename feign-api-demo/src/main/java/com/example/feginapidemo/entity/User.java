package com.example.feginapidemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * @author 雨天留恋
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class User extends FatherEntity {
    private String name;
    private String password;
    private String userName;
    private String email;
    private Date birthDate;
    private Integer age;
    private Integer sex;

}
