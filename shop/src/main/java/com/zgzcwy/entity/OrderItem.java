package com.zgzcwy.entity;

import java.io.Serializable;

/**
 * @ClassName:  OrderItem   
 * @Description: 订单项集合 
 * @author: Administrator  
 * @date:   2018年1月18日 下午3:01:39   
 *
 */
public class OrderItem implements Serializable{

	private static final long serialVersionUID = 6812521886697602496L;
	/**
	 * 订单id
	 */
	private Integer itemid;
	/**
	 * 数量
	 */
	private Integer count;
	/**
	 * 小计
	 */
	private Double subtotal;
	/**
	 * 订单项包含的商品信息
	 */
	private Product product;
	/**
	 * 订单项所属的订单
	 */
	private Order order;
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "OrderItem [itemid=" + itemid + ", count=" + count + ", subtotal=" + subtotal + ", product=" + product
				+ ", order=" + order + "]";
	}
	

}
