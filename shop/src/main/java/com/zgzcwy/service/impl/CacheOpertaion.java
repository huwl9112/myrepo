/*
 * Copyright (C), 2013-2014, 江苏飞搏软件技术有限公司
 * FileName: LogInsertOperation.java
 * Date:     2014年10月20日 下午4:15:13  
 * History: //修改记录
 * author: hej
 * desc: 日志记录切面 记录操作前及操作后的记录状态
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */

package com.zgzcwy.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

/**
 * 
 * 添加用户操作日志.
 * 
 * @author hej
 * 
 */
@Aspect
@Component
public class CacheOpertaion {
    Logger logger = LoggerFactory.getLogger(CacheOpertaion.class);
    
    /**
     * 功能描述: 后置通知，匹配com.dyk.dtp..* &&@CacheAnnotation
     * 
     * @param jp 连接点
     * @param logAnnotation 注解 
     * @return
     */
    @Around("within(com.dyk.dtp..*) && @annotation(cacheAnnotation)")
    public Object addLogAfter(ProceedingJoinPoint jp, CacheAnnotation cacheAnnotation) {
        Object retValue = null;
        try {
            logger.debug("正在执行的方法名称:" + jp.getSignature().getName());
            Class c=Class.forName(cacheAnnotation.classService());
            Object service=c.newInstance();
            retValue = jp.proceed();
            logger.debug("处理结果" + JSON.toJSONString(retValue));
        } catch (Throwable e) {
            logger.error("日志记录-函数执行异常", e);
        }
        return retValue;
    }
}
