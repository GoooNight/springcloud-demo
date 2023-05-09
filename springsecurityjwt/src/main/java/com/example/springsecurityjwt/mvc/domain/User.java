package com.example.springsecurityjwt.mvc.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 用户表(User)实体类
 *
 * @author Gooonight
 * @since 2023-04-10 19:34:55
 */
@Slf4j
@Data
@ApiModel("用户表(User)实体类")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"password","orderByMe","orderByMeSort"}, allowSetters = true, ignoreUnknown = true)
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 411950685100914250L;
    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    @TableField("user_name")
    @NotBlank(message = "用户名不能为空！！")
    private String name;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空！！")
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 用此变量排序
     */
    @ApiModelProperty(value = "用此变量排序")
    @TableField(exist = false)
    private String orderByMe;
    /**
     * 升降序
     * <p>
     * ASC：表示按升序排序
     * <p>
     * DESC：表示按降序排序
     */
    @ApiModelProperty(value = "升降序 ASC：表示按升序排序 DESC：表示按降序排序")
    @TableField(exist = false)
    private String orderByMeSort;


}

