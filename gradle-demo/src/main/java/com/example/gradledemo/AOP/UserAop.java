package com.example.gradledemo.AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

/**
 * @author 雨天留恋
 * @date 2023-04-17 13:18
 */
@Aspect
@Configuration
public class UserAop {

    /**
     * @param :
     * @return void
     * @author 雨天留恋
     * @description execution 可以去表示需要执行的位置，注解使用注解的英文单词@annotation，
     * 后面的public 表示公开的方法，后面在写方法位置以及方法名字，print(..)表示方法名字和传入参数为多个。
     * @date 2023/4/17 13:39
     */
    @Pointcut("execution(public * com.example.gradledemo.controller.UserController.print(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void print() {
        System.out.println("---------aop切面控制---------");
    }
}
