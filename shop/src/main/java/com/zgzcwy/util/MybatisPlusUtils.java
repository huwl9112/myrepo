//-------------------------------------------------------------------------
// Copyright (c) 2000-2016 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: allnas
//
//-------------------------------------------------------------------------
// APACHE
//-------------------------------------------------------------------------
package com.zgzcwy.util;

import java.io.File;
import java.util.Objects;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MybatisPlusUtils
{
    public static void main(String[] args)
    {
        String[] models = { "" };
        for (String model : models)
        {
            shell(model);
        }
    }

    private static void shell(String model)
    {
        boolean flag = false;
        File file = null;
        if (Objects.equals(model, "medicine-dao-mapper"))
        {
            file = new File("medicine-dao");
            flag = true;
        }else {
            file = new File(model);
        }
        String path = file.getAbsolutePath();
        path = path.replace("medicine-service\\", "");

        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        if(flag) {
            gc.setOutputDir(path + "/src/main/java");// 需要生成的resources目录
        }else {
            gc.setOutputDir(path + "/src/main/java");// 需要生成的java目录
        }
        
        gc.setFileOverride(true);// 是否覆盖
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(false);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setMapperName("%sDao");
        gc.setServiceName("%sService");
        gc.setAuthor("allnas");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType)
            {
                return super.processTypeConvert(fieldType);
            }
        });
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl(
                "jdbc:mysql://172.16.1.11:3306/medicine_info?characterEncoding=utf8");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        //strategy.setTablePrefix(new String[] { "t_" });
        strategy.setInclude(new String[] { "insurance_policy","medicine_policy","user","medicine","user_insurance_policy","user_medicine_policy","user_medicine" });
     // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(null);
        pc.setEntity("com.zgzcwy.entity");
        pc.setMapper("com.zgzcwy.dao");
        pc.setXml("com.zgzcwy.mapper");
        pc.setController("com.zgzcwy.controller");
        pc.setService("com.zgzcwy.service");
        pc.setServiceImpl("com.zgzcwy.service.impl");

        mpg.setPackageInfo(pc);

        TemplateConfig tc = new TemplateConfig();
       /* switch (model)
        {
        case "medicine-dao":
            tc.setEntity(null);
            tc.setXml(null);
            tc.setController(null);
            tc.setService(null);
            tc.setServiceImpl(null);
            break;
        case "medicine-dao-mapper":
            tc.setEntity(null);
            tc.setMapper(null);
            tc.setController(null);
            tc.setService(null);
            tc.setServiceImpl(null);
            break;
        case "medicine-model":
            tc.setController(null);
            tc.setService(null);
            tc.setServiceImpl(null);
            tc.setMapper(null);
            tc.setXml(null);
            break;
        case "medicine-service":
            tc.setController(null);
            tc.setMapper(null);
            tc.setXml(null);
            tc.setEntity(null);
            break;
        case "medicine-web":
            tc.setMapper(null);
            tc.setXml(null);
            tc.setService(null);
            tc.setServiceImpl(null);
            tc.setEntity(null);
            break;
        default:
            break;
        }*/
        mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();
    }
}
