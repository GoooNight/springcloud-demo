package com.example.testeve.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author 雨天留恋
 * @date 2023-09-28 11:01
 * Bean的拓展点：在所有Bean初始化之前和初始化之后生效，对自己不生效，因为自己也是bean
 * 先创建所有的BeanPostProcessor，可能不止一个
 * 在创建其他的Bean
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        System.out.println("03-调用BeanPostProcessor构造器");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("cat".equals(beanName)){
            System.out.println("12-调用了postProcessBeforeInitialization方法");
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("cat".equals(beanName)){
            System.out.println("15-调用了postProcessAfterInitialization方法");
        }

        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
