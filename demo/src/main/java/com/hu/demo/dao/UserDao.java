package com.hu.demo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hu.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author allnas
 * @since 2018-07-23
 */
public interface UserDao extends BaseMapper<User> {

    List<User> selectUserPage(Page<User> userPage, Map<String,Object> params);
}
