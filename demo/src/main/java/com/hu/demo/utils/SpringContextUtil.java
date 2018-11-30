package com.hu.demo.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Date: 2018/7/30 16:13
 * @Author: huwl
 * @Description:spring 上下文工具
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.context=applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return context;
    }


    public static Object getBean(String name){
        return context.getBean(name);

    }

    public static <T> T getBean(Class<T> classz){
        return context.getBean(classz);
    }

}
