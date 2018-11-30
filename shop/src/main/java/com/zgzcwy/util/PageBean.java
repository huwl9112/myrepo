package com.zgzcwy.util;

import java.util.List;
/**
 * @ClassName:  PageBean   
 * @Description: 分页显示数据类
 * @author: Administrator  
 * @date:   2018年1月10日 下午4:06:00   
 *
 */
public class PageBean<T> {
	private Integer page;// 当前页数.
	private Integer limit;// 每页显示记录数
	private Integer totalCount;// 总记录数
	private Integer totalPage;// 总页数.
	private List<T> list; // 显示到浏览器的数据.
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
