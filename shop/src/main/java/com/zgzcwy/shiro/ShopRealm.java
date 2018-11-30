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
package com.zgzcwy.shiro;

import java.util.Objects;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zgzcwy.entity.User;
import com.zgzcwy.service.UserService;

public class ShopRealm extends AuthorizingRealm {
	private static final Logger LOGGER = LoggerFactory.getLogger(ShopRealm.class);
	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return new SimpleAuthorizationInfo();
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		ShopUsernamePasswordToken token = (ShopUsernamePasswordToken) authenticationToken;
		String capture = token.getCapture();
		if (!capture.equalsIgnoreCase((String) SecurityUtils.getSubject().getSession().getAttribute("capture"))) {
			throw new IncorrectCaptchaException("验证码错误");
		}
		String username = token.getUsername();
		User user = userService.findByUserName(username);
		if (Objects.isNull(user)) {
			throw new UnknownAccountException("该账号不存在");// 账号不存在
		}
		if (Objects.equals(user.getStatus(), 1)) {
			throw new LockedAccountException("该账号已停用");// 账号停用
		}

		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
		// 保存到session
		SecurityUtils.getSubject().getSession().setAttribute("currentUser", user);

		return authenticationInfo;
	}

}
