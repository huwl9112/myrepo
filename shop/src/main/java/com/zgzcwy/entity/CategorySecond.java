package com.zgzcwy.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName:  CategorySecond   
 * @Description:  二级分类实体类
 * @author: Administrator  
 * @date:   2018年1月10日 上午10:08:05   
 *
 */
public class CategorySecond implements Serializable{
	
	private static final long serialVersionUID = 4659691762419052358L;
	/**
	 * 二级分类id
	 */
	private Integer csid;
	/**
	 * 二级分类名称
	 */
	private String csname;
	/**
	 * 二级分类所属一级分类对象
	 */
	private Category category;
	/**
	 * 商品集合
	 */
	private List<Product> products;
	
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
	public Category getCategory() {
		return category;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
