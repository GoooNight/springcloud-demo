package com.example.testeve.service.impl;

import com.example.testeve.service.Animal;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author 雨天留恋
 * @date 2023-06-05 13:54
 */
@Service()
public class Cat implements Animal, InitializingBean, DisposableBean, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware {

    private String name;

    private Integer age = 1;

    private String beanName;

    public String getBeanName() {
        return this.beanName;
    }

    public Cat() {
        System.out.println("06-无参构造器");
    }

    @PostConstruct
    public void myInit() {
        System.out.println("13-调用@PostConstruct注解方法");
    }

    @PreDestroy
    public void myPreDestroy() {
        System.out.println("17-调用@PreDestroy注解方法");
    }


    @Override
    public void say() {
        System.out.println("16-I am a cat.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("14-调用接口InitializingBean的方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("18-调用接口DisposableBean的方法");
    }

    @Override
    public void setBeanName(@NonNull String beanName) {
        this.beanName = beanName;
        System.out.println("09-Bean的名称为："+beanName);
    }

    @Override
    public void setBeanFactory(@NonNull BeanFactory beanFactory) throws BeansException {
        System.out.println("10-构造工场为："+ beanFactory);
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        System.out.println("11-应用上下文："+ applicationContext);
    }

}
