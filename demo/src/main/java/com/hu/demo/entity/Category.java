package com.hu.demo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author allnas
 * @since 2018-07-23
 */
public class Category extends Model<Category> {

    private static final long serialVersionUID = 1L;

	@TableId(value="cid", type= IdType.AUTO)
	private Integer cid;
	private String cname;


	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	protected Serializable pkVal() {
		return this.cid;
	}

	@Override
	public String toString() {
		return "Category{" +
			"cid=" + cid +
			", cname=" + cname +
			"}";
	}
}
