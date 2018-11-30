package com.hu.demo.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

public class MyUsernamePasswordToken extends UsernamePasswordToken {


	public MyUsernamePasswordToken() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7219100556618652327L;

	private String capture;

	public MyUsernamePasswordToken(String username, char[] password, boolean rememberMe, String host,
                                   String capture) {
		super(username, password, rememberMe, host);
		this.capture = capture;
	}

	public String getCapture() {
		return capture;
	}

	public void setCapture(String capture) {
		this.capture = capture;
	}

}
