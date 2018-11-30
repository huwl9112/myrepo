package com.hu.demo.log;

import com.alibaba.fastjson.JSON;
import com.hu.demo.datasource.SqlContextHolder;
import com.hu.demo.entity.OperationLog;
import com.hu.demo.service.OperationLogService;
import com.hu.demo.utils.ShiroUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Date: 2018/7/27 14:59
 * @Author: huwl
 * @Description:
 */
@Component
@Aspect
public class LogAspect {
    Logger logger=LoggerFactory.getLogger(LogAspect.class);
    @Autowired
    private OperationLogService logService;

    @AfterReturning(returning="rvt",pointcut = "execution(* com.hu.demo.controller.*.*(..)) && @annotation(logAnontation)")
    public void addLogAfter(JoinPoint jp, LogAnontation logAnontation, Object rvt) {
        logger.debug("正在执行的方法名称:" + jp.getSignature().getName());
        Object retValue = null;
        OperationLog log=new OperationLog();
        log.setOperTime(LocalDateTime.now());
        String className=jp.getTarget().getClass().getName();//获取类名
        String methodName=jp.getSignature().getName();//获取方法名
        Object[] args=jp.getArgs();//获取参数
        Object object=rvt;//返回值
        Class<?> clazz=object.getClass();
        log.setOperContent(SqlContextHolder.getSql());
        log.setOperMoudel(logAnontation.model());
        log.setOperTable(clazz.getSimpleName());
        log.setOperType(logAnontation.operType());
        //log.setOperId(ShiroUtil.getCurrentUser().getUid());
        SqlContextHolder.clearSql();//用完释放，防止内存泄漏
        logService.insert(log);
    }
}
