package com.hu.demo.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hu.demo.datasource.DataSourceAnontation;
import com.hu.demo.entity.ReturnResult;
import com.hu.demo.entity.User;
import com.hu.demo.log.LogAnontation;
import com.hu.demo.service.UserService;
import com.hu.demo.utils.CheckCodeGenerator;
import com.hu.demo.utils.GetRequestParamsUtil;
import com.hu.demo.utils.SysConstant;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author allnas
 * @since 2018-07-23
 * 分页只需传入page参数，查询结果会自动组装到page里
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("getDataList")
    @DataSourceAnontation(dataSource=SysConstant.MASTER)
    @ApiOperation(value="分页获取用户列表")
    public ReturnResult getDataList(@RequestParam(name = "pageNumber", defaultValue = "1") int pageNumer, @RequestParam(name = "pageSize", defaultValue = "4") int pageSize, HttpServletRequest request) {
        Map<String, Object> params = GetRequestParamsUtil.getRequestParams(request);
        Page<User> userPage = new Page<User>(pageNumer, pageSize);
        Page<User> userPage1=userService.selectPage(userPage,new EntityWrapper<User>());
        List<User> list= userService.selectUserPage(userPage, params);
        ReturnResult result = new ReturnResult();
        result.setCode("success");
        result.setData(userPage.getRecords());
        result.setPages(userPage.getPages());
        result.setTotal(userPage.getTotal());
        result.setMsg("获取成功");
        return result;
    }

    @GetMapping("add")
    @ApiOperation(value="新增用户")
    @LogAnontation(model="用户管理",operType = "新增",operTable = "User")
    public User add(@RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date day){
        User user=new User();
        user.setAddr("nanjing city");
        user.setCode("no0001");
        user.setEmail("1576581989");
        user.setSex("femail");
        user.setUsername("alis");
        user.setPhone("13409879018");
        /** 随机产生一段字符串，用于用户的密码加密 **/
        String password = user.getUsername();
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        SimpleHash hash = new SimpleHash("md5", password, user.getUsername() + salt, 2);
        user.setPassword(hash.toHex());
        user.setSalt(salt);
        userService.insert(user);
        return user;
    }

    /**
     * 获取图形验证码 将返回一个包含4位字符（字母或数字）的图形验证码，并且将图形验证码的值设置到用户的 session 中
     *
     * @param time     时间戳
     * @param response 返回的 HttpServletResponse 响应
     */
    //@ApiIgnore 这样,该接口就不会暴露在 swagger2 的页面下
    @ApiOperation(value="获取验证码")
    @RequestMapping(value = "checkCode/{time}", method = RequestMethod.GET)
    public void getCheckCode(@PathVariable("time") String time, HttpServletResponse response, HttpServletRequest request) {

        BufferedImage checkCodeImage = null;
        String checkCodeString = null;

        // 获取图形验证码
        Map<String, Object> checkCode = CheckCodeGenerator.generlateCheckCode();

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
                //logger.error("fail to get the ServletOutputStream");
            }
        }
    }
}

