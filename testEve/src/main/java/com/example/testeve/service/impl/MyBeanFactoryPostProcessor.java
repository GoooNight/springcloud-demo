package com.example.testeve.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author 雨天留恋
 * @date 2023-09-28 12:23
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public MyBeanFactoryPostProcessor() {
        System.out.println("01-调用BeanFactoryPostProcessor构造器");
    }

    /***
     * @param beanFactory:
     * @author 雨天留恋
     * @description 当BeanFactory创建之后自动调用一次
     * @date 2023/9/28 12:27
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("02-调用了BeanFactoryPostProcessor的postProcessBeanFactory方法");
    }
}
