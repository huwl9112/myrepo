package com.hu.demo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hu.demo.dao.AdminuserDao;
import com.hu.demo.entity.Adminuser;
import com.hu.demo.service.AdminuserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author allnas
 * @since 2018-07-23
 */
@Service
@Slf4j
public class AdminuserServiceImpl extends ServiceImpl<AdminuserDao, Adminuser> implements AdminuserService {

    public String execute() {
        try {
            Thread.sleep(5000);
            log.info("Slow task executed");
            return "Task finished";
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }


}
