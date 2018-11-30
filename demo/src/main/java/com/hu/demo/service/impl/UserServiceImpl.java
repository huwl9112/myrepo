package com.hu.demo.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hu.demo.dao.UserDao;
import com.hu.demo.entity.User;
import com.hu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author allnas
 * @since 2018-07-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectUserPage(Page<User> userPage, Map<String, Object> params) {
        return userDao.selectUserPage(userPage,params);
    }
}
