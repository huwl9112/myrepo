package com.zgzcwy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zgzcwy.dao.LoginMapper;
import com.zgzcwy.entity.User;
import com.zgzcwy.service.LoginService;
/**
 * @ClassName:  LoginServiceImpl   
 * @Description:  登录操作实现类
 * @author: Administrator  
 * @date:   2018年1月8日 上午11:08:17   
 *
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginMapper loginMapper;
    /**
     * 根据用户名和密码查询用户
     */
	@Override
	public User findUserByUsernaeAndPassword(String username,String password) {
		User user= loginMapper.findUserByUsernaeAndPassword(username,password);
		System.out.println();
		return user;
	}

}
