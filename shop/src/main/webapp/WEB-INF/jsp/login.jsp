<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>会员登录</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
</head>
<body>

<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="${pageContext.request.contextPath}/index">
				<img
					src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo1.gif"
					alt="京华亿家"/>
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
		<img src="${pageContext.request.contextPath}/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障"/>
</div>	
</div>
	<%@ include file="header.jsp" %>
	<%@ include file="menu.jsp" %>
</div>	
<div class="container login">
		<div class="span12">
<div class="ad">
	<img src="${pageContext.request.contextPath}/image/login.jpg" width="500" height="330" alt="会员登录" title="会员登录"/>
</div>		
</div>
		<div class="span12 last"> 
			<div class="wrap">
				<div class="main">
					<div class="title">
						<strong>会员登录</strong>USER LOGIN
					</div>
					<div class="title">
					</div>
					<form id="loginForm" action="${ pageContext.request.contextPath }/login"  method="post" >
						<table>
							<tbody><tr>
								<th>
										用户名:
								</th>
								<td>
									<input type="text" id="username" name="username" class="text" placeholder="请输入账号" maxlength="20"/>
								</td>
							</tr>
							<tr>
								<th>
									密&nbsp;&nbsp;码:
								</th>
								<td>
									<input type="password" id="password" name="password" class="text" placeholder="请输入密码" maxlength="20" autocomplete="off"/>
								</td>
							</tr>
								<tr>
									<th>
										验证码:
									</th>
									<td>
										<span class="fieldSet">
											<input type="text" id="checkCode" name="capture" class="text captcha" maxlength="4"/>&nbsp;&nbsp;&nbsp;<img
												id="checkCodeImg" alt="checkCodeImg"
												src="${pageContext.request.contextPath}/user/checkCode/1" onclick="refreshCheckCode()"/>
									</span>
									</td>
									<td><span style="font-size:12px;color:#ff0000;">${msg}</span></td>
								</tr>
							  <tr>
								<th>
								&nbsp;
								</th>
								<td>
									<label>
										<input type="checkbox" id="remember-me" name="remember-me" value="true"/>记住密码
									</label>
									<label>
										&nbsp;&nbsp;<a >找回密码</a>
									</label>
								</td>
							</tr>
							<tr>
								<th>&nbsp;
									
								</th>
								<td>
									<input type="submit" class="submit" value="登 录"/>
								</td>
							</tr>
							<tr class="register">
								<th>&nbsp;
									
								</th>
								<td>
									<dl>
										<dt>还没有注册账号？</dt>
										<dd>
											立即注册即可体验在线购物！
											<a href="${ pageContext.request.contextPath }/userRegist">立即注册</a>
										</dd>
									</dl>
								</td>
							</tr>
						</tbody></table>
					</form>
				</div>
			</div>
		</div>
	</div>
<div class="container footer">
	<div class="span24">
	  <div class="footerAd"><img src="${pageContext.request.contextPath}/image/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势" /></div>	
	</div>
	<div class="span24">
		<ul class="bottomNav">
					<li>
						<a >关于我们</a>
						|
					</li>
					<li>
						<a>联系我们</a>
						|
					</li>
					<li>
						<a>招贤纳士</a>
						|
					</li>
					<li>
						<a>法律声明</a>
						|
					</li>
					<li>
						<a>友情链接</a>
						|
					</li>
					<li>
						<a target="_blank">支付方式</a>
						|
					</li>
					<li>
						<a  target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a>服务声明</a>
						|
					</li>
					<li>
						<a>广告声明</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2005-2018 Mango商城 版权所有</div>
	</div>
</div>
<script type="text/javascript">
    // 刷新图形验证码
	function refreshCheckCode() {
			var timestamp = new Date().getTime();
			$("#checkCodeImg").attr("src", "${pageContext.request.contextPath}/user/checkCode/" + timestamp)
	}
  /*   js实现记住密码功能 */
	// 得到cookie  
    function getCookie(c_name) {  
        if (document.cookie.length > 0) {  
            c_start = document.cookie.indexOf(c_name + "=");  
            if (c_start != -1) {  
                c_start = c_start + c_name.length + 1;  
                c_end = document.cookie.indexOf(";", c_start);  
                if (c_end == -1)  
                    c_end = document.cookie.length;  
                return unescape(document.cookie.substring(c_start, c_end));  
            }  
        }  
        return "";  
    }  
  
    // 删除cookie  
    function delCookie(name) {  
        var exp = new Date();  
        exp.setTime(exp.getTime() - 1);  
        var cval = getCookie(name);  
        if (cval != null)  
            document.cookie = name + "=" + cval + ";expires="  
                    + exp.toGMTString();  
    }  
    // 设置cookie  
    function setCookie(c_name, value, expiredays) {  
        var exdate = new Date();  
        exdate.setDate(exdate.getDate() + expiredays);  
        document.cookie = c_name  
                + "="  
                + escape(value)  
                + ((expiredays == null) ? "" : ";expires="  
                        + exdate.toGMTString());  
    }  
  
    // 判断复选框是否选中  
    function isChecked(bool) {  
        if (bool) {  
            var password = $("#password").val(); 
            var username=$("#username").val();
            setCookie("password", password, 10);
            setCookie("username", username, 10);
        } else {  
            delCookie("password");  
        }  
    }  
    $(function() {  
        // 设置复选框点击事件  
        $("#remember-me").click(function() {  
            var bool = $("#remember-me").prop("checked");  
            isChecked(bool);  
        });  
  
        /*Map<String(Cookie名称),Cookie(Cookie本身)>*/  
        // 获取cookie中的用户名  
        var username = window.decodeURI("${cookie.username.value}");  
        if ("${sessionScope.user.username}") {  
            username = "${sessionScope.user.username}";  
        }  
        $("#username").val(username);  
  
        // 获取cookie中的密码  
        var password = getCookie("password");  
        if ("${sessionScope.user.password}") {  
            password = "${sessionScope.user.password}";  
        }  
        $("#password").val(password);  
  
        // 密码框加载完毕就要判断复选框  
        var bool = $("#remember-me").prop("checked");  
        isChecked(bool);  
    });  

</script>
</body>
</html>