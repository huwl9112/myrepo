package com.zgzcwy.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

public class ShopUsernamePasswordToken extends UsernamePasswordToken {


	public ShopUsernamePasswordToken() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7219100556618652327L;

	private String capture;

	public ShopUsernamePasswordToken(String username, char[] password, boolean rememberMe, String host,
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
