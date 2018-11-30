/*
 * Copyright (C), 2013-2014, 江苏飞搏软件技术有限公司
 * FileName: LogAnnotation.java
 * Date:     2014年10月20日 下午4:15:13  
 * History: 
 * author: hej
 * desc: 日志记录注解
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */

package com.zgzcwy.service.impl;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 缓存注解<br>
 * @param keyName 缓存键名
 * @param operationType 操作类型 0新增 1修改 2删除 .
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface CacheAnnotation {

    String keyName();

    int operationType();
    
    String classService();


}
