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
public class Categorysecond extends Model<Categorysecond> {

    private static final long serialVersionUID = 1L;

	@TableId(value="csid", type= IdType.AUTO)
	private Integer csid;
	private String csname;
	private Integer cid;


	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public String getCsname() {
		return csname;
	}

	public void setCsname(String csname) {
		this.csname = csname;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Override
	protected Serializable pkVal() {
		return this.csid;
	}

	@Override
	public String toString() {
		return "Categorysecond{" +
			"csid=" + csid +
			", csname=" + csname +
			", cid=" + cid +
			"}";
	}
}
