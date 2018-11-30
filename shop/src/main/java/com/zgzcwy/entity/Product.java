package com.zgzcwy.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName:  Product   
 * @Description:  商品实体类
 * @author: Administrator  
 * @date:   2018年1月9日 下午3:38:35   
 *
 */
public class Product implements Serializable{

	private static final long serialVersionUID = -2870386329194920788L;
	/**
	 * 商品id
	 */
	private Integer pid;
	/**
	 * 商品名称
	 */
	private String pname;
	/**
	 * 市场价格
	 */
	private double marketPrice;
	/**
	 * 商品价格
	 */
    private double shopPrice;
    /**
     * 图片路径
     */
    private String image;
    /**
     * 商品描述
     */
    private String pdesc;
    /**
     * 是否是热门商品
     */
    private Integer isHot;
    /**
     * 商品日期
     */
    private Date pdate;
    /**
     * 商品所属二级分类
     */
    private CategorySecond categorySecond;
    
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}
	public double getShopPrice() {
		return shopPrice;
	}
	public void setShopPrice(double shopPrice) {
		this.shopPrice = shopPrice;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public Integer getIsHot() {
		return isHot;
	}
	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	
	public CategorySecond getCategorySecond() {
		return categorySecond;
	}
	public void setCategorySecond(CategorySecond categorySecond) {
		this.categorySecond = categorySecond;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", marketPrice=" + marketPrice + ", shopPrice=" + shopPrice
				+ ", image=" + image + ", pdesc=" + pdesc + ", isHot=" + isHot + ", pdate=" + pdate
				+ ", categorySecond=" + categorySecond + "]";
	}
    
}
