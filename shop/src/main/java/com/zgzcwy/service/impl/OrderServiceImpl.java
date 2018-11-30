package com.zgzcwy.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zgzcwy.dao.OrderMapper;
import com.zgzcwy.entity.Order;
import com.zgzcwy.entity.OrderItem;
import com.zgzcwy.service.OrderService;
/**
 * @ClassName:  OrderServiceImpl   
 * @Description: 订单的实现层 
 * @author: Administrator  
 * @date:   2018年1月18日 下午3:12:58   
 *
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMapper orderMapper;
    /**
     * 保存订单
     */
	@Transactional
	@Override
	public Integer save(Order order) {
		return orderMapper.save(order);
	}
	/**
	 * 保存订单条目
	 */
	@Transactional
	@Override
	public Integer saveOrderItem(OrderItem orderItem) {
		return orderMapper.saveOrderItem(orderItem);
	}
	/**
	 * 根据oid查询订单
	 */
	@Override
	public Order findOrderByoid(Integer oids) {
		return orderMapper.findOrderByoid(oids);
	}
	/**
	 * 根据订单id查询订单项集合
	 */
	@Override
	public List<OrderItem> findOrderItemByOid(Integer oids) {
		return orderMapper.findOrderItemByOid(oids);
	}
	/**
	 * 修改订单
	 */
	@Override
	public void updateOrder(Order currOrder) {
		 orderMapper.updateOrder(currOrder);
	}
	@Override
	public List<Order> findOrderByUserId(Integer userId) {
		return orderMapper.findOrderByUserId(userId);
	}
	

}
