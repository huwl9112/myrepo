package com.hu.weixin.demo.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

/**
 * 证书信任管理器（用于https请求）
 * 这个证书管理器的作用就是让它信任我们指定的证书，下面的代码意味着信任所有证书，不管是否权威机构颁发。
 *
 * @author：huwl
 * @date：2018年1月23日 下午3:22:19
 */
@Slf4j
public class HttpsUtil {
/**
 * 发送https请求
 *
 * @param requestUrl
 *            请求地址
 * @param requestMethod
 *            请求方式（GET、POST）
 * @param outputStr
 *            提交的数据
 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
 */
public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        try {
        // 创建SSLContext对象，并使用我们指定的信任管理器初始化
        TrustManager[] tm = { new MyX509TrustManager() };
        SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
        sslContext.init(null, tm, new java.security.SecureRandom());
        // 从上述SSLContext对象中得到SSLSocketFactory对象
        SSLSocketFactory ssf = sslContext.getSocketFactory();

        URL url = new URL(requestUrl);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setSSLSocketFactory(ssf);

        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        // 设置请求方式（GET/POST）
        conn.setRequestMethod(requestMethod);

        // 当outputStr不为null时向输出流写数据
        if (null != outputStr) {
        OutputStream outputStream = conn.getOutputStream();
        // 注意编码格式
        outputStream.write(outputStr.getBytes("UTF-8"));
        outputStream.close();
        }

        // 从输入流读取返回内容
        InputStream inputStream = conn.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = null;
        StringBuffer buffer = new StringBuffer();
        while ((str = bufferedReader.readLine()) != null) {
        buffer.append(str);
        }

        // 释放资源
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        inputStream = null;
        conn.disconnect();
        jsonObject = JSONObject.parseObject(buffer.toString());
        } catch (ConnectException ce) {
        log.error("连接超时：{}", ce);
        } catch (Exception e) {
        log.error("https请求异常：{}", e);
        }
        return jsonObject;
        }}