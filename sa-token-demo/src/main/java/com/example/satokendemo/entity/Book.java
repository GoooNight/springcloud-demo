package com.example.satokendemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 雨天留恋
 * @date 2023-06-12 19:37
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

    private String id;

    private String name;

    private Date publicationDate;


}
