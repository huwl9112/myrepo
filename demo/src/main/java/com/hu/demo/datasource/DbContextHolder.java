package com.hu.demo.datasource;

/**
 * @Date: 2018/8/1 14:44
 * @Author: huwl
 * @Description:
 */
public class DbContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    /**
     * 设置数据源
     * @param dbTypeEnum
     */
    public static void setDbType(String dbType) {
        contextHolder.set(dbType);
    }

    /**
     * 取得当前数据源
     * @return
     */
    public static String getDbType() {
        return contextHolder.get();
    }

    /**
     * 清除上下文数据
     */
    public static void clearDbType() {
        contextHolder.remove();
    }

}
