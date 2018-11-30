package com.zgzcwy.dao;

import org.apache.ibatis.annotations.Param;

import com.zgzcwy.entity.User;

/**
 * 
 * @ClassName:  UserDao   
 * @Description:  注册用户数据持久层
 * @author: Administrator  
 * @date:   2017年12月29日 下午2:44:54   
 *
 */
public interface UserMapper {
    /**
     * 注册用户
     * @param user
     * @return
     */
	int addUser(User user);
    /**
     * 校验用户名是否存在
     * @param username
     * @return
     */
	User findByUserName(@Param("username")String username);

}
