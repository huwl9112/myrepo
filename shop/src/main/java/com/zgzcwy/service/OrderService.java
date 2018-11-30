package com.zgzcwy.service;

import java.util.List;

import com.zgzcwy.entity.Order;
import com.zgzcwy.entity.OrderItem;

/**
 * @ClassName:  OrderService   
 * @Description: 订单的service 
 * @author: Administrator  
 * @date:   2018年1月18日 下午3:12:05   
 *
 */
public interface OrderService {
    /**
     * 保存订单
     * @param order
     * @return
     */
	Integer save(Order order);
    /**
     * 保存订单条目
     * @param orderItem
     * @return
     */
	Integer saveOrderItem(OrderItem orderItem);
	/**
	 * 根据oid查询订单
	 * @param oids
	 * @return
	 */
	Order findOrderByoid(Integer oids);
	/**
	 * 根据订单id查询订单项集合
	 * @param oids
	 * @return
	 */
	List<OrderItem> findOrderItemByOid(Integer oids);
	/**
	 * 修改订单
	 * @param currOrder
	 */
	void updateOrder(Order currOrder);
	/**
	 * 我的订单
	 * @param userId
	 * @return
	 */
	List<Order> findOrderByUserId(Integer userId);

}
