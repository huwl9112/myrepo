package com.hu.weixin.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Date: 2018/9/4 15:44
 * @Author: huwl
 * @Description:#
 * spring.mvc.static-path-pattern=默认值为 /**
 * spring.resources.static-locations=这里设置要指向的路径，多个使用英文逗号隔开,默认值为 classpath:/META-INF/resources/,classpath:/resources/,classpath:/static/,    classpath:/public/
 * 比如我把spring.mvc.static-path-pattern=/demo/**，那么上面我们的那个图片就需要通过http://localhost:8080/demo/image/timg.jpg才能访问的到，如果我改了下面的locations，那么我图片依然在static就不能访问的到了。
 */
@Controller
@RequestMapping("dtp/wxCustomer")
public class WxController {
    @GetMapping("/index")
    @ResponseBody
    public String index(@RequestParam("code") String code){
        System.out.println("code="+code);
        //通过code获取openId
        JSONObject jsonDate = getOpenId(code);
        if(jsonDate.get("errcode")==null){
            JSONObject wxUser =  getWxUser(jsonDate.getString("openid"),jsonDate.getString("access_token"));
            return JSONObject.toJSONString(wxUser);
        }
        return "home"; //当浏览器输入/index时，会返回 /templates/home.html页面
    }

    @GetMapping("/info")
    public String info(ModelMap map){
        map.addAttribute("name","huwl");
        return "home";
    }


    /**
     * 网页授权获取openId
     * @Title: getOpenId
     * @Description: TODO
     * @param code
     * @return JSONObject
     */
    public  JSONObject getOpenId(String code) {
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
        String requestUrl = url.replace("APPID", "wx67bb3d26908b52e5").replace("SECRET", "aadd9fb67f5616d9b85b8fab4ceba87b").replace("CODE", code);

        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
        return jsonObject;
    }

    /**
     * 获取用户微信信息
     * @Description: TODO
     * @param openid
     * @return JSONObject
     */
    public  JSONObject getWxUser(String openId,String accessToken) {
        System.out.println("openId============="+openId);
        String url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
        String requestUrl = url.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);

        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
        return jsonObject;
    }

    /**
     * 获取accessToken
     * @Description: TODO
     * @return JSONObject
     */
    public  String getAccessToken() {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx1f2ac54c8569d36b&secret=f7850bf6bac29cd14d65c0f0fe5a7092";
        JSONObject jsonObject = CommonUtil.httpsRequest(url, "GET", null);
        return jsonObject.getString("access_token");
    }


    /*public static void main(String[] args){//群发
        String token="16_ycQYiD-C2IgKtLPNNi8aREVnkKwgwHAPj2AJoVh6b5t1-DCYBRukehB6Suy18x9-wMs-uTbhuJgYm5F_GUYP3gBnkM-0ENLN_hGyTbPwBkeeY8gvJma_DMEG4rEZRHFMg3JZUHdeEL71mGMVRGEjACABQO";
        JSONObject param=new JSONObject();
        JSONObject filter=new JSONObject();
        filter.put("is_to_all",true);
        filter.put("tag_id",3);
        param.put("filter",filter);
        JSONObject text=new JSONObject();
        text.put("content","<a href='www.baidu.com'>点击跳转</a>");
        param.put("text",text);
        param.put("msgtype","text");

        JSONObject jsonObject = CommonUtil.httpsRequest("https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token="+token, "POST", JSONObject.toJSONString(param));
        System.out.print(jsonObject.toJSONString());

    }*/

    /*public static void main(String[] args){//个人模板消息
        String token="16_ycQYiD-C2IgKtLPNNi8aREVnkKwgwHAPj2AJoVh6b5t1-DCYBRukehB6Suy18x9-wMs-uTbhuJgYm5F_GUYP3gBnkM-0ENLN_hGyTbPwBkeeY8gvJma_DMEG4rEZRHFMg3JZUHdeEL71mGMVRGEjACABQO";
        JSONObject param=new JSONObject();
        param.put("touser","of_8cw_xMOq_hu3XOfOs1wEv05cU");
        param.put("template_id","vfNof1XdKZgvMIzIM4HP-0PEWkNxn-x7sGIy5CxeZB4");
        param.put("url","www.baidu.com");//点击跳转的url
        JSONObject data=new JSONObject();
        JSONObject val1=new JSONObject();
        val1.put("value","模板消息");
        val1.put("color","#173177");
        data.put("content",val1);
        param.put("data",data);
        String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
        JSONObject jsonObject = CommonUtil.httpsRequest(url+token, "POST", JSONObject.toJSONString(param));
        System.out.print(jsonObject.toJSONString());

    }*/



    public static void main(String[] args){//客服消息
        String token="16_ycQYiD-C2IgKtLPNNi8aREVnkKwgwHAPj2AJoVh6b5t1-DCYBRukehB6Suy18x9-wMs-uTbhuJgYm5F_GUYP3gBnkM-0ENLN_hGyTbPwBkeeY8gvJma_DMEG4rEZRHFMg3JZUHdeEL71mGMVRGEjACABQO";
        JSONObject param=new JSONObject();
        param.put("touser","of_8cw3JDkPhOqFrDrSiHKfDqtEI");
        param.put("msgtype","text");
        JSONObject val1=new JSONObject();
        val1.put("content","你的意向单已收到<a href=''>点击查看详情</a>");

        param.put("text",val1);
        String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
        JSONObject jsonObject = CommonUtil.httpsRequest(url+token, "POST", JSONObject.toJSONString(param));
        System.out.print(jsonObject.toJSONString());

    }
}
