package com.hu.demo.shiro;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hu.demo.entity.ReturnResult;
import com.hu.demo.entity.User;
import com.hu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2018/8/7 14:11
 * @Author: huwl
 * @Description:
 */
@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private UserService userService;
    @GetMapping("getAll")
    public Page getAll(){
        Page page=new Page(1,5);
        userService.selectMapsPage(page,new EntityWrapper<>());
        return page;
    }
}
