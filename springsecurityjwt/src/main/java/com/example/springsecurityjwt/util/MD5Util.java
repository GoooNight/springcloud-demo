package com.example.springsecurityjwt.util;

import org.springframework.util.DigestUtils;

import static com.example.springsecurityjwt.config.constant.Constant.MD5_SALT;

/**
 * MD5工具类
 *
 * @author Gooonight
 * @since 2023-04-10 19:34:55
 */
public class MD5Util {
    /**
     * 生成md5
     */
    public static String toMD5(String str) {
        String base = str + MD5_SALT;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }
}
