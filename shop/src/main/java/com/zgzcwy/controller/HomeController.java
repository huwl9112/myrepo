package com.zgzcwy.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zgzcwy.entity.Category;
import com.zgzcwy.entity.Product;
import com.zgzcwy.service.CategoryService;
import com.zgzcwy.service.ProductService;

/**
 * @ClassName:  HomeController   
 * @Description:   进入网站主页的控制器
 * @author: Administrator  
 * @date:   2017年12月28日 下午4:25:15   
 *
 */
@Controller
public class HomeController{
	@Autowired 
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	//热门商品的集合
	private List<Product> hotList;
	//最新商品集合
	private List<Product> newList;
	/**
	 * 首页访问的方法
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/index")
	public String index(HttpSession session,Model model) throws Exception{
		//1.查询所有一级分类
		List<Category> categoryList = categoryService.findAllCategory();
		//2.将查询出来的所有存入session
		session.setAttribute("categoryList", categoryList);
		//查询热门商品
		hotList=productService.findAllHotProduct();
		model.addAttribute("hotList", hotList);
		//查询最新商品
		newList=productService.findAllNewProduct();
		model.addAttribute("newList", newList);
		return "index";
	}
	/**
	 * 跳转到注册页面
	 * @return
	 */
	@RequestMapping("/userRegist")
	public String userRegist() throws Exception{
		return "regist";
	}
	/**
	 * 跳转到激活页面
	 */
	@RequestMapping("/message")
	public String message() throws Exception{
		return "msg";
	}
	/**
	 * 跳转到用户登录页面
	 */
	@RequestMapping("/loginPage")
	public String loginPage() throws Exception{
		return "login";
	}

}
