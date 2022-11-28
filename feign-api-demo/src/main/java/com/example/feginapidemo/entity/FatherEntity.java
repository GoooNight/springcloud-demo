package com.example.feginapidemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * @author 雨天留恋
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class FatherEntity {
    private Date insertDate;
    private Date updateDate;
    private Long id;
}
