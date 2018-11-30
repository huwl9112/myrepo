package com.example.consumer.user;

import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2018/8/7 14:42
 * @Author: huwl
 * @Description:
 */
@RestController
@RequestMapping("user")
@EnableAutoConfiguration
public class UserController {
    @Autowired
    private IFeignClient iFeignClient;
    @RequestMapping("/getAll")
    public Page getUser() {

        //调用远程服务
//		ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://sbc-order/getOrder", String.class);
//        logger.info("res="+JSON.toJSONString(responseEntity));
        return iFeignClient.getAll();
    }
}
