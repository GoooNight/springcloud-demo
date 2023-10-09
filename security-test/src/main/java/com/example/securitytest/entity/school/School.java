package com.example.securitytest.entity.school;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 雨天留恋
 * @date 2023-07-31 9:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class School {

    private Integer id;

    private String province;

    private String city;

    private String district;

    private String name;

    private String type;

}
