package com.zgzcwy.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName:  Category   
 * @Description:  一级分类实体类
 * @author: Administrator  
 * @date:   2018年1月9日 下午2:09:56   
 *
 */
public class Category implements Serializable{

	private static final long serialVersionUID = -8470418023042205402L;
	/**
	 * 一级分类id
	 */
	private Integer cid;
	/**
	 * 一级分类名称
	 */
	private String cname;
	/**
	 * 二级分类集合
	 */
	private List<CategorySecond> categorySeconds;
	
	/**
	 * 无参构造器
	 */
	public Category() {
		super();
	}
	/**
	 * 带参构造器
	 * @param cid
	 * @param cname
	 * @param categorySeconds
	 */

	public Category(Integer cid, String cname, List<CategorySecond> categorySeconds) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.categorySeconds = categorySeconds;
	}


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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(List<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
	
}
