package com.zgzcwy.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zgzcwy.dao.UserMapper;
import com.zgzcwy.entity.User;
import com.zgzcwy.service.UserService;
/**
 * 
 * @ClassName:  UserServiceImpl   
 * @Description:  用户注册实现类
 * @author: Administrator  
 * @date:   2017年12月29日 下午2:41:48   
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
    /**
     * 用户注册
     */
	@Transactional
	@Override
	public Map<String, String> addUser(User user) {
		//设置用户状态为激活
		user.setStatus(1);
		int i=userMapper.addUser(user);
		Map<String, String> map=new HashMap<String, String>();
		if(i>0){
			map.put("msg", "用户注册成功");
			return map;
		}else{
			map.put("msg","用户注册失败");
			return map;
		}
	}
	/**
	 * 校验用户名
	 */
	@Override
	public User findByUserName(String username) {
		return userMapper.findByUserName(username);
	}

}
