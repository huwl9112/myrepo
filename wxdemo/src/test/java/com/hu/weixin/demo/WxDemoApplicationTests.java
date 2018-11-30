package com.hu.weixin.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Constructor;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WxDemoApplicationTests {

    @Test
    public void contextLoads() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class c1=WxDemoApplicationTests.class;
        Class c2=Class.forName("com.hu.weixin.demo.WxDemoApplicationTests");
        WxDemoApplicationTests test=new WxDemoApplicationTests();
        Class c3=test.getClass();
        WxDemoApplicationTests t2= (WxDemoApplicationTests)c1.newInstance();
        System.out.println(t2==test);
        //Constructor<WxDemoApplicationTests> constructors=c2.getConstructor();
    }

}
