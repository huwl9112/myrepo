package com.zgzcwy.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zgzcwy.entity.User;
import com.zgzcwy.service.UserService;
import com.zgzcwy.util.CheckCodeGenerator;
/**
 * 
 * @ClassName:  UserController   
 * @Description:  用户注册
 * @author: Administrator  
 * @date:   2017年12月29日 下午2:35:37   
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	@Autowired
    private CheckCodeGenerator checkCodeGenerator;
	/**
	 * 用户注册
	 */
	@RequestMapping("/regist")
	public ModelAndView regist(User user,String checkCode,HttpSession session) throws Exception{
		//1.比较验证码
		String sessionCode=(String) session.getAttribute("capture");
		if(checkCode!=null && checkCode.equalsIgnoreCase(sessionCode)){
			logger.info("验证码："+checkCode);
			userService.addUser(user);
			logger.info("注册用户");
			ModelAndView mav=new ModelAndView("msg");
			mav.addObject("message","注册成功，请去登录！");
			return mav;
		}else{
			ModelAndView mav=new ModelAndView("regist");
			mav.addObject("err", "验证码错误！");
			return mav;
		}
	}
	/**
	 * 前台:注册AJAX校验用户名.
	 * @throws IOException 
	 */
	@RequestMapping("/CheckUserName")
	@ResponseBody
	public Map<String, String> checkUserName(String username,HttpServletRequest request) throws IOException{
		logger.info("用户名："+username);
		if(username==""||username==null){
			Map<String, String> result = new HashMap<String, String>();
			result.put("msg","null");
			return result;
		}else{
		User existUser = userService.findByUserName(username);
		logger.info("用户对象:"+existUser);
		if(existUser == null){
			// 用户名可以使用的
			Map<String, String> result = new HashMap<String, String>();
			result.put("msg","true");
			return result;
		}else{
			// 用户名已经存在
			Map<String, String> result = new HashMap<String, String>();
			result.put("msg","false");
			return result;
		}
		}
	}
	/**
     * 获取图形验证码 将返回一个包含4位字符（字母或数字）的图形验证码，并且将图形验证码的值设置到用户的 session 中
     *
     * @param time     时间戳
     * @param response 返回的 HttpServletResponse 响应
     */
    @RequestMapping(value = "checkCode/{time}", method = RequestMethod.GET)
    public void getCheckCode(@PathVariable("time") String time, HttpServletResponse response, HttpServletRequest request) {

        BufferedImage checkCodeImage = null;
        String checkCodeString = null;

        // 获取图形验证码
        Map<String, Object> checkCode = checkCodeGenerator.generlateCheckCode();

        if (checkCode != null) {
            checkCodeString = (String) checkCode.get("checkCodeString");
            checkCodeImage = (BufferedImage) checkCode.get("checkCodeImage");
        }

        if (checkCodeString != null && checkCodeImage != null) {
            try (ServletOutputStream outputStream = response.getOutputStream()) {
                // 设置 Session
                HttpSession session = request.getSession();
                session.setAttribute("capture", checkCodeString);

                // 将验证码输出
                ImageIO.write(checkCodeImage, "png", outputStream);

                response.setHeader("Pragma", "no-cache");
                response.setHeader("Cache-Control", "no-cache");
                response.setDateHeader("Expires", 0);
                response.setContentType("image/png");
            } catch (IOException e) {
                logger.error("fail to get the ServletOutputStream");
            }
        }
    }

}
