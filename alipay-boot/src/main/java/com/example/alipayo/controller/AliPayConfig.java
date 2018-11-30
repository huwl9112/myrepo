package com.example.alipayo.controller;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Date: 2018/10/31 9:30
 * @Author: huwl
 * @Description:
 */
@ConfigurationProperties(prefix = "alipay")
@Data
@Component
public class AliPayConfig {

    /**
     * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
     */
    private String appID;

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    private String merchantPrivateKey;

    /**
     * 支付宝公钥
     */
    private String alipayPublicKey;

    /**
     * 签名方式
     */
    private String signType;

    /**
     * 网关
     */
    private String gatewayUrl;

    /**
     * 编码
     */
    private String  charset;

    /**
     * 异步通知地址
     */
    private String notifyUrl;

    /**
     * 类型
     */
    private String returnUrl;

    /**
     * 商户号
     */
    private String  sysServiceProviderId="1234";

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getMerchantPrivateKey() {
        return merchantPrivateKey;
    }

    public void setMerchantPrivateKey(String merchantPrivateKey) {
        this.merchantPrivateKey = merchantPrivateKey;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getGatewayUrl() {
        return gatewayUrl;
    }

    public void setGatewayUrl(String gatewayUrl) {
        this.gatewayUrl = gatewayUrl;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getSysServiceProviderId() {
        return sysServiceProviderId;
    }

    public void setSysServiceProviderId(String sysServiceProviderId) {
        this.sysServiceProviderId = sysServiceProviderId;
    }
}