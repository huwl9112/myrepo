package com.zgzcwy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zgzcwy.entity.User;
import com.zgzcwy.service.LoginService;

/**
 * @ClassName:  LoginController   
 * @Description:  用户登录登出
 * @author: Administrator  
 * @date:   2018年1月5日 上午11:37:06   
 *
 */
@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private LoginService loginService;
	/**
	 * 登录
	 * @param mav
	 * @param username
	 * @param password
	 * @param checkCode
	 * @param session
	 * @return
	 */
	/*@RequestMapping("/login")
	public ModelAndView login(
			ModelAndView mav,
			String username,
			String password,
			String checkCode,
			HttpServletRequest request,
			HttpSession session){
		logger.info("用户名"+username);
		logger.info("密码"+password);
		if("GET".equalsIgnoreCase(request.getMethod())) {
			mav.setViewName("login");
    		return mav;
		}
		//1.比较验证码
	    String sessionCode=(String) session.getAttribute("checkCode");
	    if(checkCode!=null&&checkCode.equalsIgnoreCase(sessionCode)){
	    	logger.info("验证码："+checkCode);
	    	//登录操作
	    	User user=loginService.findUserByUsernaeAndPassword(username,password);
	    	logger.info("user"+user);
	    	if(user!=null){
	    	//验证用户状态
	    		int status=user.getStatus();
	    		if(status==1){
	    			session.setAttribute("user",user);
	    			mav.setViewName("redirect:index");
	    			logger.info("登录成功");
	    			return mav;
	    		}else{
	    			mav.addObject("msg","请联系管理员");
	    			mav.setViewName("login");
	    			return mav;
	    		}
	    	}else{
	    		mav.addObject("msg","用户名或者密码错误");
	    		mav.setViewName("login");
	    		return mav;
	    	}
	    }else{
	    	mav.addObject("msg","验证码错误");
	    	mav.setViewName("login");
	    	return mav;
	    }
	}*/
	
	 /**
     * 通过index跳转到登录页面(防止登录页面在center panel中)
     * 
     * @return
     */
    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest req,ModelAndView mav) {
    	mav.setViewName("login");
    	if(WebUtils.toHttp(req).getMethod().equalsIgnoreCase("GET")) {
    		return mav;
    	}
        // 设置校验的结果信息(异常类名)
        /*req.getSession().setAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME,
                req.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME));*/
        mav.addObject("msg",req.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME));
    	return mav;
    }
	/**
	 * 登出
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		//销毁session
		session.invalidate();
		return "redirect:index";
	}
}
