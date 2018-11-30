package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092000555131";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDTKqPuAwx0GcSQBURaF9tAr5JvLJ8yuLL/EHlr2/Dn1cmmv54BR2V6vkFIvf4n0XD8Y32vz8X2NxkRGLZMpNyOKQu3/y8cu0uCsyS3LsHePrs9wb3HgW/i3rzvSBe1btMzNjz0pP+dbcTvfjuxBXWXRZQoCUvaCJBqGU/6RnJaunJDawpCDgXwpgadODJGLOLpFpreaFJtbTu5Fx2mg3uKpzQhv+jzAm7sd1R6MV15nqZ3rMVu1M/UcwSWUwIMNY8LLvavO4aNQ7wY1fomPNXJF3MD/Vd5URPf+bYh2Ghj6/iTCSOH8yXg0VhRMLud+beZXby0P7jzcbXgREhRm7LjAgMBAAECggEANFEzLivpMPaVYY08gwm4E42sPQkUJC/ogRMm0hc612V7QWnmDrEOrltmt0wDJQBZ+t33bNCQXlEGT9sMh26tCjeXJK3/kSHCMo6JwSy/cX2fTEys5Tnna5D9xFbbMONVRjHg5kfe4LUqfp+K0G/m02S0sTqkZU+L4A2HaB1+BYYKrqyn5RuV3O0DGCOVTmrfaeKJ9PJgtdkvLIbhzA4i9uC+PPk7WWEBvyiXTxw7wfJ3Q6v9zi8Azv5AW2NYiioobuaRGSDtuz/PN9Z8B6dPbwTb3bpnuXeFEYbw3gnbgN8uwaY6phNzSM6RuMJft5wKH3ACRREbFYFMPDx2yPQy8QKBgQDx2MMvbhyVHQxjfAM2RC87zUpGcp/MWonhp6bdIcdpqGFEHMKuLwGs4sXnE7Ru3QwPmTbTsIzzRQQzDvnUkh64G3ylyNo4I+38ranrBgRzkk2zV04fl8XQ/GQb6WUBmP45Nvy8j1J62h9UQDw9z4rn+WO/7a/SDxaWRD+SyGxFOQKBgQDfhj3dGhywR0vgcW6KbRr3HIYv8g+atWD+kGuwvsGahAqrbJFBePb7FAvbO/UTF6Re3UYyKYr+yhFBOVcxNJx3eC/RKjT9LgtmyQDEN5zAZcyOlZUSAxNNNx1sm8SfLYV1TqGkkOH7mr6m+dL67eQJ9AqL+y9EVIc9+6WO5sZ0+wKBgQDd7FSfb2FXC4LUv3WLFGJrc+QWZRRxxxsDMH6UKGz+bX5jrCiRAZ198dI8Sv6lRL3Oin+fHUEZ8lj6KWHjR/pcYwysbHSiU4YM+acUfT8UdkpKqXCM2Q6yyQdr/W2sW6HdCrI8rR+4j/NzskYVSh9i4pxAAHH4RdQqK5JStQt1MQKBgQCgkEi+G7TB9+UMa88RBsDZA5dst3/4DRSIqGuDQfPGr9UOQOWy11brEwJVUKOCPHhpYJ+9BtR+o95zMOJuSTGgLCiFIsF/oOS1x+uSB7TFDBs9zTuQ/b6Ot+meC+LYyRVWJ867bQu39fe/8DNa5yno8HHnDd9tQR8JKkxJ84JZowKBgFsjahHckyDWoGKnjJZpNlauG2fHQ9GmrWNpfG4l/sZ4+b3J2boFvI7xx+D2E3en1KYc8BT14mmqWoFrybJ9jfFFQquaI6iX9Lrz7SBD2U8CunYhlGRI5T2s9FwzQtVkxUUaRI/eUN7cryZnjFXzasIOqJWyzqaDV6WMrSguXBsA";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyqtimHpFwncGNIi4/wFgFvaPWAyeyo/DrPOZ0tZ+ZCsLrbkgUGlf7kQc+EsXWllfbO0wjk2EUFo8C0pthuozjk2kXE/T463svQVlw6KOg5JhK+ZFm7Se5ePwV5TgXiu7Z1IP+gEEV09Mqb5i+rORXAUi6ZNaNvl6xJbcUlEe9UR+kKSbRWhKJuhYa7sR0hzj+rqSlMohZDEA3Vof/oq9gRSNMW4FAmqRdDcPSe/Jzfl2m/N6LFGnurxADcl/yaRHf03v+CA8ms5yO2SXkOjdTTaiagv/Zx41W4VWvrzlXl9ZOPWi9G+5emSkQZZhVbTYORAegcUlRJ5RtcusdhbGqQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://v21d802929.51mypc.cn/pay/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://v21d802929.51mypc.cn/pay/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

