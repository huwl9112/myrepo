package com.zgzcwy.service;

import com.zgzcwy.entity.User;

/**
 * @ClassName:  LoginService   
 * @Description:  登录操作接口
 * @author: Administrator  
 * @date:   2018年1月8日 上午11:07:31   
 *
 */
public interface LoginService {
    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
	User findUserByUsernaeAndPassword(String username, String password);

}
