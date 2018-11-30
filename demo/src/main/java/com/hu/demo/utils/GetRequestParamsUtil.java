package com.hu.demo.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Date: 2018/7/24 15:18
 * @Author: huwl
 * @Description:获取请求参数
 */
public class GetRequestParamsUtil {
    public static Map<String,Object> getRequestParams(HttpServletRequest request){
        Map<String,Object> params=new HashMap<>();
        Enumeration<String> requestNames=request.getParameterNames();
        while(requestNames.hasMoreElements()){
            String requestName=requestNames.nextElement();
            Object requestValue=request.getParameter(requestName);
            params.put(requestName,requestValue);
        }
        return params;
    }
}
