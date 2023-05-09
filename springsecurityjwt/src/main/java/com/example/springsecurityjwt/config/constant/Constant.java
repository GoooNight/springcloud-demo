package com.example.springsecurityjwt.config.constant;


/**
 * 常量
 *
 * @author Gooonight
 * @since 2023-04-10 19:34:55
 */
public interface Constant {
    /**
     * 全局异常包路径
     */
    String PACKAGE_NAME = "com.example.springsecurityjwt";

    /**
     * swagger扫描包
     */
    String SWAGGER_PACKAGE = "com.example.springsecurityjwt.mvc.controller";

    /**
     * MD5盐用于混交md5
     */
    String MD5_SALT = "-50549493239723899LMD5Util";
}

