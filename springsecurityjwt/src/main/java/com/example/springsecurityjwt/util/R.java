package com.example.springsecurityjwt.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;

/**
 * 统一返回对象R
 *
 * @author Gooonight
 * @since 2023-04-10 19:34:55
 */
@Slf4j
@ApiModel("统一返回对象R")
@Getter
public class R implements Serializable {
    @Serial
    private static final long serialVersionUID = -92371841307494129L;
    @ApiModelProperty(value = "响应编码")
    private int code;
    @ApiModelProperty(value = "响应信息")
    private String message;
    @ApiModelProperty(value = "token")
    private String token;
    @ApiModelProperty(value = "响应数据")
    private Object data;

    /**
     * 私有构造方法
     */
    private R() {
    }

    /**
     * 设置数据
     *
     * @param data 数据
     * @return R
     */
    public R data(Object data) {
        this.data = data;
        return this;
    }

    /**
     * 成功
     *
     * @return R
     */
    public static R ok() {
        R r = new R();
        r.code = HttpStatus.OK.value();
        r.message = HttpStatus.OK.getReasonPhrase();
        return r;
    }
    /**
     * 登录成功
     * 用来返回token
     *
     * @return R
     */
    public static R loginOk(String token) {
        R r = new R();
        r.code = HttpStatus.OK.value();
        r.message = HttpStatus.OK.getReasonPhrase();
        r.token = token;
        return r;
    }
    /**
     * 由于被认为是客户端错误
     * 错误的请求语法
     * 无效的请求消息帧或欺骗性的请求路由
     * 服务器无法或不会处理请求。
     *
     * @return R
     */
    public static R badRequest() {
        R r = new R();
        r.code = HttpStatus.BAD_REQUEST.value();
        r.message = HttpStatus.BAD_REQUEST.getReasonPhrase();
        return r;
    }


    /**
     * 认证授权失败 Unauthorized
     * 请求要求用户的身份认证
     * 客户端必须对自身进行身份验证才能获得请求的响应
     *
     * @return R
     */
    public static R unauthorized() {
        R r = new R();
        r.code = HttpStatus.UNAUTHORIZED.value();
        r.message = HttpStatus.UNAUTHORIZED.getReasonPhrase();
        return r;
    }

    /**
     * Forbidden
     * 服务器理解请求客户端的请求，但是拒绝执行此请求
     * 客户端没有访问内容的权限，也就是说，它是未经授权的，因此服务器拒绝提供请求的资源。
     * 与401Unauthorized不同，服务器知道客户端的身份。
     *
     * @return R
     */
    public static R forbidden() {
        R r = new R();
        r.code = HttpStatus.FORBIDDEN.value();
        r.message = HttpStatus.FORBIDDEN.getReasonPhrase();
        return r;
    }

    /**
     * Internal Server Error
     * 服务器内部错误，无法完成请求
     *
     * @return R
     */
    public static R exp() {
        R r = new R();
        r.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        r.message = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
        return r;
    }
    /**
     * NOT FOUND
     * 404
     *
     * @return R
     */
    public static R notFound() {
        R r = new R();
        r.code = HttpStatus.NOT_FOUND.value();
        r.message = HttpStatus.NOT_FOUND.getReasonPhrase();
        return r;
    }
}
