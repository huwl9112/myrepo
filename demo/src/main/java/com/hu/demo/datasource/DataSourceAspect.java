package com.hu.demo.datasource;

import com.hu.demo.entity.ReturnResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Date: 2018/8/1 14:54
 * @Author: huwl
 * @Description:
 * Spring AOP仅支持方法执行类型的Joinpoint 所以execution将会是我们用的最多的标志符，用它来帮我们匹配拥有指定方法前面的Joinpoint。匹配规则如下：
 * execution(modifiers-pattern? return-type-pattern declaring-type-pattern? name-pattern(param-pattern) throws-pattern)
 * modifiers-pattern 修饰符 比如public private这种（可以指定可以不指定）
 * return-type-pattern 返回值类型（必须指定）
 * declaring-type-pattern 类型（可以是含包名的全路径类型 可以指定可以不指定）
 * name-pattern 方法名（必须指定）
 * param-pattern 参数类型（必须指定）
 *    *：匹配任何数量字符；
 *    ..：匹配任何数量字符的重复，如在类型模式中匹配任何数量子包；而在方法参数模式中匹配任何数量参数。
 *     +：匹配指定类型的子类型；仅能作为后缀放在类型模式后边。
 */
@Component
@Aspect
@Order(-100)//多个注解时，保证先执行，值越小越优先
public class DataSourceAspect {
    Logger logger=LoggerFactory.getLogger(DataSourceAspect.class);
    /*
     * 定义一个注解切入点
     */
    @Pointcut("@annotation(com.hu.demo.datasource.DataSourceAnontation)")
    public void dataAnnotation() {
    }


    // 用@Pointcut来注解一个切入方法
    @Pointcut("execution(* com.hu.demo.controller.*.*(..))")
    public void dataService() {
    }

    @Around("within(com.hu.demo..*) && @annotation(dataAnontation)")
    public Object switchDataSource(ProceedingJoinPoint pjp, DataSourceAnontation dataAnontation) {
        logger.info("切换到数据源..."+dataAnontation.dataSource());
        DbContextHolder.setDbType(dataAnontation.dataSource());
        try {
            Object rt=  pjp.proceed();
            DbContextHolder.clearDbType();//用完释放，防止内存泄漏
            return rt;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            DbContextHolder.clearDbType();
            return null;
        }
    }
}
