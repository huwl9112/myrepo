package com.hu.demo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author allnas
 * @since 2018-07-23
 */
@Data
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
	@TableId(value="uid", type= IdType.AUTO)
	private Integer uid;
    /**
     * 用户名
     */
	private String username;
    /**
     * 密码
     */
	private String password;
    /**
     * 邮箱
     */
	private String email;
    /**
     * 性别
     */
	private String sex;
    /**
     * 电话
     */
	private String phone;
    /**
     * 地址
     */
	private String addr;
    /**
     * 用户状态，0代表未激活，1代表已经激活
     */
	private Integer status;
    /**
     * 激活码
     */
	private String code;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 电话
     */
    private String salt;


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
	protected Serializable pkVal() {
		return this.uid;
	}

	@Override
	public String toString() {
		return "User{" +
			"uid=" + uid +
			", username=" + username +
			", password=" + password +
			", email=" + email +
			", sex=" + sex +
			", phone=" + phone +
			", addr=" + addr +
			", status=" + status +
			", code=" + code +
			"}";
	}
}
