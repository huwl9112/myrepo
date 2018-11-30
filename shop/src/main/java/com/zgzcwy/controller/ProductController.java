package com.zgzcwy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zgzcwy.entity.Category;
import com.zgzcwy.entity.Product;
import com.zgzcwy.service.CategoryService;
import com.zgzcwy.service.ProductService;
import com.zgzcwy.util.PageBean;

/**
 * @ClassName:  ProductController   
 * @Description:  商品控制器
 * @author: Administrator  
 * @date:   2018年1月9日 下午4:12:35   
 *
 */
@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	PageBean<Product> pageBean =new PageBean<Product>();
	/**
	 * 查询一级分类下的商品
	 * @param model
	 * @param cid
	 * @param page
	 * @return
	 */
	@RequestMapping("/productfindByCid")
	public String findProducts(Model model,Integer cid,Integer page){
		//查询一级分类
		List<Category> categoryList = categoryService.findAllCategory();
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("cid", cid);
		//查询商品
		pageBean=productService.findByPage(cid,page);
		model.addAttribute("pageBean", pageBean);
		return "list";
	}
	@RequestMapping("/productfindByCsid")
	public String productfindByCsid(Model model,Integer csid,Integer page){
		//查询一级分类
		List<Category> categoryList = categoryService.findAllCategory();
		model.addAttribute("categoryList", categoryList);
		//查询二级分类的商品
		pageBean = productService.findByCsid(csid, page);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("csid", csid);
		return "cslist";
	}
	@RequestMapping("/productfindByPid")
	public String productfindByPid(Model model,Integer pid){
		// 查询所有一级分类:
		List<Category> categoryList = categoryService.findAllCategory();
		model.addAttribute("categoryList", categoryList);
		//根据商品id查询商品详情
		Product product=productService.productfindByPid(pid);
		model.addAttribute("product", product);
		return "desc";
	}
    
}
