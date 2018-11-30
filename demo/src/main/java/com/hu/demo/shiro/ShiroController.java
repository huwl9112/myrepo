package com.hu.demo.shiro;

import com.alibaba.fastjson.JSONObject;
import com.hu.demo.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/11.
 */
@RestController
public class ShiroController {

    /**
     * 登录方法
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/ajaxLogin")
    public JSONObject ajaxLogin(User userInfo) {
        JSONObject jsonObject = new JSONObject();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(), userInfo.getPassword());
        try {
            subject.login(token);
            jsonObject.put("token", subject.getSession().getId());
            jsonObject.put("code", true);
            jsonObject.put("msg", "登录成功");
        } catch (IncorrectCaptchaException e) {
            jsonObject.put("code", false);
            jsonObject.put("msg", "验证码错误");
        }
        catch (IncorrectCredentialsException e) {
            jsonObject.put("code", false);
            jsonObject.put("msg", "密码错误");
        } catch (LockedAccountException e) {
            jsonObject.put("code", false);
            jsonObject.put("msg", "登录失败，该用户已被冻结");
        } catch (ExcessiveAttemptsException e) {
            jsonObject.put("msg", "尝试次数过多");
        }
        catch (UnknownAccountException e) {
            jsonObject.put("code", false);
            jsonObject.put("msg", "该用户不存在");
        }
        catch (Exception e) {
            jsonObject.put("code", false);
            jsonObject.put("msg", "登录异常");
        }
        return jsonObject;
    }

    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * @return
     */
    @RequestMapping(value = "/unauth")
    public Object unauth() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", false);
        map.put("msg", "未登录,请先登录");
        return map;
    }
}
