package com.zgzcwy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zgzcwy.service.CategoryService;

/**
 * @ClassName:  CategoryController   
 * @Description:  一级分类控制器
 * @author: Administrator  
 * @date:   2018年1月9日 上午11:15:24   
 *
 */
@Controller("/category")
public class CategoryController {
	 @Autowired
	private CategoryService categoryService;

}
