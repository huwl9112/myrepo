package com.zgzcwy.service;

import java.util.List;

import com.zgzcwy.entity.Product;
import com.zgzcwy.util.PageBean;

/**
 * @ClassName:  ProductService   
 * @Description:  商品业务接口
 * @author: Administrator  
 * @date:   2018年1月9日 下午4:14:37   
 *
 */
public interface ProductService {
	/**
	 * 查询热门商品
	 * @return
	 */

	List<Product> findAllHotProduct();
    /**
     * 查询最新商品
     * @return
     */
	List<Product> findAllNewProduct();
	/**
	 * 分页查询商品
	 * @param cid
	 * @param page
	 * @return
	 */
	PageBean<Product> findByPage(Integer cid, Integer page);
	/**
	 * 查询二级分类的商品
	 * @param csid
	 * @param page
	 * @return
	 */
	PageBean<Product> findByCsid(Integer csid, Integer page);
	 /**
     * 根据商品id查询商品详情
     * @param pid
     * @return
     */
	Product productfindByPid(Integer pid);

}
