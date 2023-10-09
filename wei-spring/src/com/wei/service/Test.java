package com.wei.service;

import com.wei.spring.WeiSpringApplicationContext;

/**
 * @author 雨天留恋
 * @date 2023-06-25 10:44
 */
public class Test {

    public static void main(String[] args) {
        WeiSpringApplicationContext applicationContext = new WeiSpringApplicationContext(AppConfig.class);

        UserService userService = (UserService) applicationContext.getBean("userService");

    }
}
