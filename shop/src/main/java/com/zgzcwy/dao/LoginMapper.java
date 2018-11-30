package com.zgzcwy.dao;

import org.apache.ibatis.annotations.Param;

import com.zgzcwy.entity.User;
/**
 * @ClassName:  LoginMapper   
 * @Description:  登录操作数据持久层
 * @author: Administrator  
 * @date:   2018年1月8日 上午11:13:03   
 *
 */
public interface LoginMapper {
    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
	User findUserByUsernaeAndPassword(@Param("username")String username,@Param("password")String password);

}
