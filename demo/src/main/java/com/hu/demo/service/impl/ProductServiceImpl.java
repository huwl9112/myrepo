package com.hu.demo.service.impl;

import com.hu.demo.entity.Product;
import com.hu.demo.dao.ProductDao;
import com.hu.demo.service.ProductService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author allnas
 * @since 2018-07-23
 */
public class ProductServiceImpl extends ServiceImpl<ProductDao, Product> implements ProductService {

}
