package com.zgzcwy.entity;

import java.io.Serializable;

/**
 * 
 * @ClassName:  User   
 * @Description:用户信息实体类  
 * @author: Administrator  
 * @date:   2017年12月28日 下午5:57:37   
 *
 */
public class User implements Serializable{
	private static final long serialVersionUID = 1215935134757419427L;
	/**
	 * 用户id
	 */
	private Integer uid;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 联系地址
	 */
	private String addr;
	/**
	 * 用户状态
	 */
	private Integer status;
	/**
	 * 激活码
	 */
	private String code;
	/**
	 * 无参构造器
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
    /**
     * 带参构造器
     * @param uid
     * @param username
     * @param password
     * @param email
     * @param sex
     * @param phone
     * @param addr
     * @param status
     * @param code
     */
	public User(Integer uid, String username, String password, String email, String sex, String phone, String addr,
			Integer status, String code) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.sex = sex;
		this.phone = phone;
		this.addr = addr;
		this.status = status;
		this.code = code;
	}
    
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", email=" + email + ", sex="
				+ sex + ", phone=" + phone + ", addr=" + addr + ", status=" + status + ", code=" + code + "]";
	}
	
	

}
