package com.hu.demo;

import com.alibaba.fastjson.JSON;
import com.hu.demo.entity.User;
import com.hu.demo.service.OperationLogService;
import com.hu.demo.service.UserService;
import com.hu.demo.utils.SpringContextUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Scanner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoApplication.class)//加载spring上下文但获取不到属性文件
public class DemoApplicationTests {

    @Autowired
    private OperationLogService operationLogService;


    @Test
    public void contextLoads() {
        //System.out.println(JSON.toJSONString(operationLogService.selectList(null)));
    }}
