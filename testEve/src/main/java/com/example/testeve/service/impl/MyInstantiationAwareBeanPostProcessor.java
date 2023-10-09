package com.example.testeve.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author 雨天留恋
 * @date 2023-09-28 14:21
 * 实例化执行器
 */
@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {


    public MyInstantiationAwareBeanPostProcessor() {
        System.out.println("04-InstantiationAwareBeanPostProcessor构造器");
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if ("cat".equals(beanName)) {
            System.out.println("05-实例化之前，可以拿到字节码-"+ beanName);
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("cat".equals(beanName)) {
            System.out.println("07-实例化结束，之后是初始化前置处理-"+ beanName);
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if ("cat".equals(beanName)) {
            System.out.println("08-属性赋值postProcessProperties方法-"+ beanName);
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }
}
