package com.zgzcwy.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zgzcwy.entity.Cart;
import com.zgzcwy.entity.CartItem;
import com.zgzcwy.entity.Order;
import com.zgzcwy.entity.OrderItem;
import com.zgzcwy.entity.User;
import com.zgzcwy.service.OrderService;

/**
 * @ClassName:  OrderController   
 * @Description:  订单的controller
 * @author: Administrator  
 * @date:   2018年1月18日 下午3:05:48   
 *
 */
@Controller
public class OrderController {
	
	private static final Logger logger=LoggerFactory.getLogger(OrderController.class);
	
    @Autowired
    private OrderService orderService;
    /**
     * 保存订单
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/saveOrder")
    public String saveOrder(Model model,HttpSession session){
    	OrderItem orderItem = new OrderItem();
    	Order order=new Order();
    	/********************封装订单数据*************/
    	order.setOrdertime(new Date());
    	order.setState(1);//1 未付款   2 已经付款.  3.已经发货   4 已经收货.
    	// 有些数据需要从购物车中获取
    	//获得购物车
    	Cart cart = (Cart) session.getAttribute("cart");
    	if(cart == null){
			model.addAttribute("message","您还没有购物!请先去购物!");
			return "msg";
		}
    	//订单总价
    	order.setTotal(cart.getTotal());
    	//订单所属用户
    	User user=(User) session.getAttribute("user");
    	if(user==null){
    		model.addAttribute("message","您还没有登录!请先去登录!");
    		return "msg";
    	}
    	order.setUser(user);
    	// 保存订单:
		Integer oid = orderService.save(order);
		logger.info("oid:"+oid);
		Integer oids=order.getOid();
		logger.info("oids"+oids);
    	/********************封装订单项数据*************/
    	for (CartItem cartItem : cart.getCartItems()) {
    		orderItem.setCount(cartItem.getCount());
    		orderItem.setSubtotal(cartItem.getSubtotal());
    		orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrder(order);
			//保存订单条目
			Integer itemId=orderService.saveOrderItem(orderItem);
		}
		//根据订单id查询出所有订单项
		List<OrderItem> orderItems=orderService.findOrderItemByOid(oids);
		order.setOrderItems(orderItems);
		System.out.println(order);
		// 清空购物车.
		cart.clearCart();
		model.addAttribute("order",order);
		return "order";
    	
    }
    /**
     * 订单付款
     * @param orderId
     * @param name
     * @param orderPhone
     * @param orderAddr
     * @param model
     * @return
     */
    @RequestMapping("/orderPayOrder")
    public String orderPayOrder(Integer orderId,String name,String orderPhone,String orderAddr,Model model){
		//修改订单
    	//根据订单id查询订单
    	Order currOrder=orderService.findOrderByoid(orderId);
    	currOrder.setAddr(orderAddr);
    	currOrder.setName(name);
    	currOrder.setPhone(orderPhone);
    	orderService.updateOrder(currOrder);
    	// 付款:
		// 定义付款的参数:
    	/**********此处不做付款功能,实际项目中可根据公司的支付技术选型接入相应支付接口即可***********/
    	//付款成功后重定向到回调方法
    	//假设已付款
    	
    	return "redirect:callBack";
    }
    /**
     * 付款成功后的回调方法
     * @param r3_Amt
     * @param r6_Order
     * @param model
     * @return
     */
    @RequestMapping("/callBack")
    public String callBack(String r3_Amt,String r6_Order,Model model){
    	/***注意：r3_Amt和r6_Order在本项目中都为null,因为我们没有实现支付功能***/
    	//r3_Amt代表支付成功后，支付平台传过来的支付金额，r6_Order代表传过来的订单id,
    	//修改订单状态
    	//Order currOrder = orderService.findOrderByoid(Integer.parseInt(r6_Order));
    	//实际项目中订单编号发生修改,是因为没有查询出订单。
    	//currOrder.setState(2);//2代表已付款
    	//修改订单状态
    	//orderService.updateOrder(currOrder);
    	model.addAttribute("message", "订单付款成功!订单号:"+r6_Order+"支付金额:"+r3_Amt);
    	//返回消息页面
		return "msg";
    }
    /**
     * 我的订单
     */
    @RequestMapping("/myOrder")
    public String myOrder(HttpSession session,Model model){
    	User user=(User) session.getAttribute("user");
    	if(user==null){
    		model.addAttribute("message","您还没有登录，请先去登录");
    		return "msg";
    	}
    	Integer userId=user.getUid();
    	List<Order> orderList=orderService.findOrderByUserId(userId);
    	System.out.println(orderList);
    	model.addAttribute("orderList", orderList);
		return "orderlist";
    }
    /**
     * 查询单个订单
     * @param oid
     * @return
     */
    @RequestMapping("/findByOid")
    public String findByOid(Integer oid,Model model){
    	Order order=orderService.findOrderByoid(oid);
    	model.addAttribute("order",order);
    	System.out.println(order);
		return "order";
    }
}
