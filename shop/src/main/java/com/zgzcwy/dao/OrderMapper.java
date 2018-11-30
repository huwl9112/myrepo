package com.zgzcwy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zgzcwy.entity.Order;
import com.zgzcwy.entity.OrderItem;

/**
 * @ClassName:  OrderMapper   
 * @Description: 订单的mapper
 * @author: Administrator  
 * @date:   2018年1月18日 下午3:53:16   
 *
 */
public interface OrderMapper {
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
	 * 查询订单
	 * @param oids
	 * @return
	 */
	Order findOrderByoid(@Param("oids")Integer oids);
	/**
	 * 根据订单id查询订单项集合
	 * @param oids
	 * @return
	 */
	List<OrderItem> findOrderItemByOid(@Param("oids")Integer oids);
	/**
	 * 修改订单
	 * @param currOrder
	 * @return
	 */
	void updateOrder(Order currOrder);
	/**
	 * 根据userI查询订单集合
	 * @param userId
	 * @return
	 */
	List<Order> findOrderByUserId(@Param("userId")Integer userId);

}
