package com.hu.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.hu.demo.utils.SysConstant;
import com.hu.demo.datasource.DynamicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Date: 2018/7/23 16:35
 * @Author: huwl
 * @Description:数据源配置
 */
@Configuration
public class DataSourceConfig {

    @Bean(name="master")
    //@Primary // 在同样的DataSource中，首先使用被标注的DataSource
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource master(){
        return new DruidDataSource();
    }

    @Bean(name="slave")
    //@Primary // 在同样的DataSource中，首先使用被标注的DataSource
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slave(){
        return new DruidDataSource();
    }

    /**
     * 动态数据源配置
     * @return
     */
    @Bean(name="multipleDataSource")
    @Primary
    public DataSource multipleDataSource (@Qualifier("master") DataSource master,
                                          @Qualifier("slave") DataSource slave ) {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map< Object, Object > targetDataSources = new HashMap<>();
        targetDataSources.put(SysConstant.MASTER,master );
        targetDataSources.put(SysConstant.SLAVE, slave);
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(master);
        return dynamicDataSource;
    }

    // 配置事物管理器
    @Bean(name="transactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("multipleDataSource") DataSource multipleDataSource){
        return new DataSourceTransactionManager(multipleDataSource);
    }

}
