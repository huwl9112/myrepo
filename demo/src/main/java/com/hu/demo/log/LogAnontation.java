package com.hu.demo.log;

import java.lang.annotation.*;

/**
 * @Date: 2018/7/27 14:29
 * @Author: huwl
 * @Description:
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LogAnontation {
    String model();//系统模块
    String operType();//操作类型
    String operTable();//操作的表
}
