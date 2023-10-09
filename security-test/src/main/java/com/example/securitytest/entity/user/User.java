package com.example.securitytest.entity.user;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 雨天留恋
 * @date 2023-07-08 10:01
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @TableId
    private Integer id;

    private String name;

}
