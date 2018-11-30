package com.hu.demo.datasource;

/**
 * @Date: 2018/8/1 14:44
 * @Author: huwl
 * @Description:
 */
public class SqlContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    /**
     * 设置数据源
     * @param dbTypeEnum
     */
    public static void setSql(String sql) {
        contextHolder.set(sql);
    }

    /**
     * 取得当前数据源
     * @return
     */
    public static String getSql() {
        return contextHolder.get();
    }

    /**
     * 清除上下文数据
     */
    public static void clearSql() {
        contextHolder.remove();
    }

}
