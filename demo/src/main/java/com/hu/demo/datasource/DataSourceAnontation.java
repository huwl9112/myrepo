package com.hu.demo.datasource;

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
public @interface DataSourceAnontation {
    String dataSource();//数据源类型
}
