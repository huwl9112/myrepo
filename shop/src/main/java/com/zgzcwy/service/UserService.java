package com.zgzcwy.service;

import java.util.Map;

import com.zgzcwy.entity.User;

/**
 * @ClassName:  UserService   
 * @Description:  用户注册接口
 * @author: Administrator  
 * @date:   2017年12月29日 下午2:37:42   
 *
 */
public interface UserService {
    /**
     * 用户注册
     * @param user
     * @return
     */
	Map<String, String> addUser(User user);
    /**
     * 校验用户名
     * @param username
     * @return
     */
	User findByUserName(String username);

}
