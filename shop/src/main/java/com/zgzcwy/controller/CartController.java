package com.zgzcwy.controller;

import com.zgzcwy.entity.Cart;
import com.zgzcwy.entity.CartItem;
import com.zgzcwy.entity.Product;
import com.zgzcwy.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @ClassName:  CartController   
 * @Description:购物车模块  
 * @author: Administrator  
 * @date:   2018年1月17日 上午10:13:24   
 *
 */
@Controller
public class CartController {
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	@Autowired
	private ProductService productService;
	/**
	 * 从session范围获得购物车代码。
	 * @param session
	 * @return
	 */
	public Cart getCart(HttpSession session){
		//从session范围内获得Cart对象
		Cart cart = (Cart) session.getAttribute("cart");
		//判断
		if(cart==null){
			//创建购物车对象
			cart=new Cart();
			//将购物车对象放入session。
			session.setAttribute("cart", cart);
		}
		return cart;
	}
	/**
	 * 加入购物车
	 * @param session
	 * @param pid
	 * @param count
	 * @return
	 */
	@RequestMapping("/addCart")
	public String addCart(HttpSession session,Integer pid,Integer count){
		if(pid!=null&&count!=null){
			logger.info("pid:"+pid);
			logger.info("count:"+count);
			//根据pid查询商品信息
			Product product=productService.productfindByPid(pid);
			// 创建一个购物项对象:
			CartItem cartItem = new CartItem();
			cartItem.setCount(count);
			cartItem.setProduct(product);
			//获取购物车
			Cart cart=getCart(session);
			//Cart cart=(Cart) session.getAttribute("cart");
			cart.addCart(cartItem);
			return "cart";
		}else{
			return "cart";
		}
		
	}
	/**
	 * 清空购物车
	 * @param session
	 * @return
	 */
	@RequestMapping("/clearCart")
	public String clearCart(HttpSession session){
		//获取购物车
		Cart cart=getCart(session);
		cart.clearCart();
		return "cart";
	}
	/**
	 * 移除购物车
	 * @param session
	 * @param pid
	 * @return
	 */
    @RequestMapping("/removeCart")
    public String removeCart(HttpSession session,Integer pid){
    	//获取购物车
    	Cart cart=getCart(session);
    	logger.info("pid:==="+pid);
    	if(pid!=null){
    		cart.removeCart(pid);
    	}
    	return "cart";
   
    }
}
