package com.hu.demo.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.hu.demo.entity.User;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author allnas
 * @since 2018-07-23
 */
public interface UserService extends IService<User> {

    List<User> selectUserPage(Page<User> userPage, Map<String,Object> params);
}
