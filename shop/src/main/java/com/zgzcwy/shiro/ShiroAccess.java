//-------------------------------------------------------------------------
// Copyright (c) 2000-2016 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: allen
//
//-------------------------------------------------------------------------
// APACHE
//-------------------------------------------------------------------------
package com.zgzcwy.shiro;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
/**
 * 
 * 拦截处理ajax请求,session失效问题
 *
 * @author            allen
 * @version           1.0
 * @since             2017年12月8日
 */
public class ShiroAccess extends FormAuthenticationFilter
{
    protected Logger LOGGER=LoggerFactory.getLogger(getClass());
    @Override
    protected boolean onAccessDenied(ServletRequest request,
            ServletResponse response) throws Exception
    {
        if (this.isLoginRequest(request, response))
        {
            if (this.isLoginSubmission(request, response))
            {
                return this.executeLogin(request, response);
            }
            else
            {

                return true;
            }
        }
        else
        {
            if (isAjax(request))
            {
                Map<String, Object> result = new HashMap<String, Object>();
                result.put("isLogin", false);
                LOGGER.info("ajax请求,session失效");
                response.getWriter().print(JSONObject.toJSONString(result));
            }
            else
            {
                this.saveRequestAndRedirectToLogin(request, response);
            }
            return false;
        }
    }

    public static boolean isAjax(ServletRequest request)
    {
        String header = ((HttpServletRequest) request)
                .getHeader("X-Requested-With");
        if ("XMLHttpRequest".equalsIgnoreCase(header))
        {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
