package com.hu.demo.entity;

/**
 * @Date: 2018/7/24 14:29
 * @Author: huwl
 * @Description:包装请求返回结果
 */
public class ReturnResult {
    private  String code;
    private String msg;
    private Object data;
    private int total;//分页总条数
    private int pages;//总页数

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
