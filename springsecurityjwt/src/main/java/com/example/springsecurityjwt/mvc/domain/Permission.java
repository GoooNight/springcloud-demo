package com.example.springsecurityjwt.mvc.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;

/**
 * 权限(Permission)实体类
 *
 * @author Gooonight
 * @since 2023-05-06 15:24:22
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("权限(Permission)实体类")
public class Permission implements Serializable {
    @Serial
    private static final long serialVersionUID = 678346898084934745L;
    @ApiModelProperty(value = "")
    private String id;
    @ApiModelProperty(value = "")
    @NotBlank(message = "用户id不能为空！！！")
    private String uid;
    @ApiModelProperty(value = "")
    private Integer permission;
    /**
     * 用此变量排序
     */
    @TableField(exist = false)
    @ApiModelProperty(value = "用此变量排序")
    private String orderByMe;
    /**
     * 升降序
     * <p>
     * ASC：表示按升序排序
     * <p>
     * DESC：表示按降序排序
     */
    @TableField(exist = false)
    @ApiModelProperty(value = "升降序 ASC：表示按升序排序 DESC：表示按降序排序")
    private String orderByMeSort;
}

