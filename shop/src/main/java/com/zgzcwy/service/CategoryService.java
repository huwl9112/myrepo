package com.zgzcwy.service;

import java.util.List;

import com.zgzcwy.entity.Category;

/**
 * @ClassName:  CategoryService   
 * @Description: 一级分类接口 
 * @author: Administrator  
 * @date:   2018年1月9日 下午1:25:09   
 *
 */
public interface CategoryService {
    /**
     * 查询所有一级分类
     * @return
     */
	List<Category> findAllCategory();
   

}
