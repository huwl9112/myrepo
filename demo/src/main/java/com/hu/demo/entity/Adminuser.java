package com.hu.demo.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author allnas
 * @since 2018-07-23
 */
public class Adminuser extends Model<Adminuser> {

    private static final long serialVersionUID = 1L;

	@TableId(value="uid", type= IdType.AUTO)
	private Integer uid;
	private String username;
	private String password;


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

	@Override
	protected Serializable pkVal() {
		return this.uid;
	}

	@Override
	public String toString() {
		return "Adminuser{" +
			"uid=" + uid +
			", username=" + username +
			", password=" + password +
			"}";
	}
}
