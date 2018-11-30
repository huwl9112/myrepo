package com.zgzcwy.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zgzcwy.controller.UserController;
import com.zgzcwy.dao.CategoryMapper;
import com.zgzcwy.entity.Category;
import com.zgzcwy.service.CategoryService;
/**
 * @ClassName:  CategoryServiceImpl   
 * @Description: 一级分类实现类 
 * @author: Administrator  
 * @date:   2018年1月9日 下午1:25:29   
 *
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
	@Autowired
	private CategoryMapper categoryMapper;
    /**
     * 查询所有一级分类
     */
	@Transactional
	@Override
	public List<Category> findAllCategory() {
		return categoryMapper.findAllCategory();
	}

}
