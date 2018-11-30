package com.hu.demo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
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
public class Orders extends Model<Orders> {

    private static final long serialVersionUID = 1L;

	@TableId(value="oid", type= IdType.AUTO)
	private Integer oid;
	private Double total;
	private Date ordertime;
	private Integer state;
	private Integer uid;
    /**
     * 送货地址
     */
	private String addr;
    /**
     * 联系电话
     */
	private String phone;
    /**
     * 收货人
     */
	private String name;


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

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
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

	@Override
	protected Serializable pkVal() {
		return this.oid;
	}

	@Override
	public String toString() {
		return "Orders{" +
			"oid=" + oid +
			", total=" + total +
			", ordertime=" + ordertime +
			", state=" + state +
			", uid=" + uid +
			", addr=" + addr +
			", phone=" + phone +
			", name=" + name +
			"}";
	}
}
