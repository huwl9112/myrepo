package com.zgzcwy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zgzcwy.entity.Product;

/**
 * @ClassName:  ProductMapper   
 * @Description:  商品数据持久层
 * @author: Administrator  
 * @date:   2018年1月9日 下午4:19:46   
 *
 */
public interface ProductMapper {
    /**
     * 查询热门商品（is_hot为1的商品）
     * @return
     */
	List<Product> findAllHotProduct();
    /**
     * 查询最新商品
     * @return
     */
	List<Product> findAllNewProduct();
	/**
	 * 查询总记录数
	 * @param cid
	 * @return
	 */
	Integer findCountByCid(@Param("cid")Integer cid);
	/**
	 * 商品数据集合
	 * @param cid
	 * @param begin
	 * @param limit
	 * @return
	 */
	List<Product> findByPage(@Param("cid")Integer cid, @Param("begin")int begin, @Param("limit")int limit);
	/**
	 * 根据二级分类id查询商品
	 * @param csid
	 * @param begin
	 * @param limit
	 * @return
	 */
	List<Product> findByPageCsid(@Param("csid")Integer csid, @Param("begin")int begin, @Param("limit")int limit);
	/**
	 * 根据二级分类id查询总记录数
	 * @param csid
	 * @return
	 */
	Integer findCountByCsid(@Param("csid")Integer csid);
	/**
	 * 查询商品详情
	 * @param pid
	 * @return
	 */
	Product productfindByPid(@Param("pid")Integer pid);
	/**
	 * 根据pid查询商品
	 * @param pid
	 * @return
	 */

}
