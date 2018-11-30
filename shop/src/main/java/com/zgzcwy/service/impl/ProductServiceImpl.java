package com.zgzcwy.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zgzcwy.dao.ProductMapper;
import com.zgzcwy.entity.Product;
import com.zgzcwy.service.ProductService;
import com.zgzcwy.util.PageBean;
/**
 * @ClassName:  ProductServiceImpl   
 * @Description:  商品接口实现类
 * @author: Administrator  
 * @date:   2018年1月9日 下午4:15:57   
 *
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	@Autowired
	private ProductMapper productMapper;
    /**
     * 查询热门商品
     */
	@Transactional
	@Override
	public List<Product> findAllHotProduct() {
		return productMapper.findAllHotProduct();
	}
	/**
	 * 查询最新商品
	 */
	@Transactional
	@Override
	public List<Product> findAllNewProduct() {
		return productMapper.findAllNewProduct();
	}
	/**
	 * 分类页面分页查询商品
	 */
	@Override
	public PageBean<Product> findByPage(Integer cid, Integer page) {
		logger.info("cid:"+cid+"page:"+page);
		int limit = 12; // 每页显示记录数.
		int totalPage = 0; // 总页数
		PageBean<Product> pageBean = new PageBean<Product>();
		pageBean.setPage(page);
		pageBean.setLimit(limit);
		// 查询总记录数:
		Integer totalCount = productMapper.findCountByCid(cid);
		logger.info("总记录数"+totalCount);
		pageBean.setTotalCount(totalCount);
		// 总页数的封装
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
			logger.info("总页数"+totalPage);
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 商品数据集合:
		int begin = (page - 1) * limit;
		List<Product> list = productMapper.findByPage(cid,begin ,limit);
		pageBean.setList(list);
		return pageBean;
	}
	/**
	 * 根据二级分类查询商品
	 */
	@Override
	public PageBean<Product> findByCsid(Integer csid, Integer page) {
		int limit = 8; // 每页显示记录数.
		int totalPage = 0; // 总页数
		PageBean<Product> pageBean = new PageBean<Product>();
		pageBean.setPage(page);
		pageBean.setLimit(limit);
		// 总记录数
		Integer totalCount = productMapper.findCountByCsid(csid);
		pageBean.setTotalCount(totalCount);
		// 计算总页数:
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 数据的集合:
		int begin = (page - 1) * limit;
		List<Product> list = productMapper.findByPageCsid(csid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	/**
	 * 查询商品详情
	 */
	@Override
	public Product productfindByPid(Integer pid) {
		return productMapper.productfindByPid(pid);
	}

}
