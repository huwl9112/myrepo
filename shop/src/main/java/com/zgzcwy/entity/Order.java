package com.zgzcwy.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * @ClassName:  Order   
 * @Description:订单实体类
 * @author: Administrator  
 * @date:   2018年1月18日 下午2:54:04   
 *
 */
public class Order implements Serializable{
	
	private static final long serialVersionUID = -6586206206521575354L;
	/**
	 * 订单id
	 */
	private Integer oid;
	/**
	 * 总计
	 */
	private Double total;
	/**
	 * 下单时间
	 */
	private Date ordertime;
	/**
	 * 订单状态
	 */
	private Integer state;
	/**
	 * 送货地址
	 */
	private String addr;
	/**
	 * 联系地址
	 */
	private String phone;
	/**
	 * 收货人
	 */
	private String name;
	/**
	 *  订单的所属的用户
	 */
	private User user;
	/**
	 * 订单项集合
	 */
	private List<OrderItem> orderItems;
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", total=" + total + ", ordertime=" + ordertime + ", state=" + state + ", addr="
				+ addr + ", phone=" + phone + ", user=" + user + ", orderItems=" + orderItems + "]";
	}
	


}
