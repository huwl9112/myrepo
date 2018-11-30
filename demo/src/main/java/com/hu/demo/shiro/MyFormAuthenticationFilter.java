package com.hu.demo.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

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
		return new MyUsernamePasswordToken(username, password.toCharArray(), rememberMe, host, capture);
	}

	private String getCapture(ServletRequest request) {
		return WebUtils.getCleanParam(request, "capture");
	}

}
