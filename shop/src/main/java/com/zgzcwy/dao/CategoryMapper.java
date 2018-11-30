package com.zgzcwy.dao;

import java.util.List;

import com.zgzcwy.entity.Category;

/**
 * @ClassName:  CategoryMapper   
 * @Description: 一级分类数据持久层
 * @author: Administrator  
 * @date:   2018年1月9日 下午1:30:29   
 *
 */
public interface CategoryMapper {
    /**
     * 查询所有一级分类
     * @return
     */
	List<Category> findAllCategory();

}
