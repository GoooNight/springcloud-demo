package com.example.testeve.view;


import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

/**
 * @author 雨天留恋
 */
@Data
@Builder
public class DataView <T> {
    private Integer code;
    private String message;
    @Singular("data")
    private List<T> data;
}
