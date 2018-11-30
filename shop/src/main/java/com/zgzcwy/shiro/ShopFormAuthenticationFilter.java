package com.zgzcwy.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

public class ShopFormAuthenticationFilter extends FormAuthenticationFilter{

	@Override
	protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
		 String message = ae.getMessage();
	     request.setAttribute(getFailureKeyAttribute(), message);
	}

	@Override
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
		String username=getUsername(request);
		String password=getPassword(request);
		boolean rememberMe=isRememberMe(request);
		String host=getHost(request);
		String capture=getCapture(request);
		return new ShopUsernamePasswordToken(username, password.toCharArray(), rememberMe, host, capture);
	}

	private String getCapture(ServletRequest request) {
		return WebUtils.getCleanParam(request, "capture");
	}

}
