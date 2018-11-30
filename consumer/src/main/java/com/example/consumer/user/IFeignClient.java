package com.example.consumer.user;

import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Date: 2018/8/7 14:31
 * @Author: huwl
 * @Description:
 */
@FeignClient(name = "demo")
public interface IFeignClient {
    @RequestMapping(value="test/getAll",method = RequestMethod.GET)
    Page getAll();
}
