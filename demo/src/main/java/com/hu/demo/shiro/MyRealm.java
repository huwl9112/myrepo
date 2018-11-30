//-------------------------------------------------------------------------
// Copyright (c) 2000-2016 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: allnas
//
//-------------------------------------------------------------------------
// APACHE
//-------------------------------------------------------------------------
package com.hu.demo.shiro;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hu.demo.entity.User;
import com.hu.demo.service.UserService;
import com.hu.demo.utils.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class MyRealm extends AuthorizingRealm {
	private static final Logger LOGGER = LoggerFactory.getLogger(MyRealm.class);
	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return new SimpleAuthorizationInfo();
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		/*String capture = token.getCapture();
		if (!capture.equalsIgnoreCase((String) SecurityUtils.getSubject().getSession().getAttribute("capture"))) {
			throw new IncorrectCaptchaException("验证码错误");
		}*/
		String username = token.getUsername();
		User user = userService.selectOne(new EntityWrapper<User>().eq("username",username));
		if (Objects.isNull(user)) {
			throw new UnknownAccountException("该账号不存在");// 账号不存在
		}
		if (Objects.equals(user.getStatus(), 1)) {
			throw new LockedAccountException("该账号已停用");// 账号停用
		}

		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getUsername()+user.getSalt()),//salt=username+salt
                getName()  //realm name
        );
		// 保存到session
        ShiroUtil.setCurrentUser(user);
		return authenticationInfo;
	}

}
