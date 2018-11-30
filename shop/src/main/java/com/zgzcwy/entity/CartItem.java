package com.zgzcwy.entity;
/**
 * @ClassName:  CartItem   
 * @Description: 购物项 
 * @author: Administrator  
 * @date:   2018年1月16日 下午3:49:12   
 *
 */
public class CartItem {
	/**
	 * 商品信息
	 */
	private Product product;
	/**
	 * 数量
	 */
	private Integer count;
	/**
	 * 小计
	 */
	private double subtotal;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public double getSubtotal() {
		return count*product.getShopPrice();
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	

}
