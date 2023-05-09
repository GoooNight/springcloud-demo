package com.example.testeve.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author 雨天留恋
 * @date 2023-05-05 17:08
 */
@Data
public class User implements Serializable {
    @NotNull
    private String username;
}
