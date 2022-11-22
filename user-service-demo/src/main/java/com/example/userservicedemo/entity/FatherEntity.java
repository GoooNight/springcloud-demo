package com.example.userservicedemo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * @author 雨天留恋
 */
@Data
@SuperBuilder
public class FatherEntity {
    private Date insertDate;
    private Date updateDate;
    private Long id;
}
