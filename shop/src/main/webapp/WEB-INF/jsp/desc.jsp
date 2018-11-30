<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
	<title>京华亿家商城</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<form action="${pageContext.request.contextPath}/addCart" method="post">
<input type="hidden" name="pid" value="${product.pid }"/>
<div class="container header">
	<div class="span5">
		<div class="logo">
			<a>
				<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo1.gif" alt="京华亿家"/>
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
					<img src="${pageContext.request.contextPath}/image\r___________renleipic_01/header.jpg" alt="正品保障" title="正品保障" height="50" width="320"/>
</div>	</div>
	<%@ include file="header.jsp" %>
	<%@ include file="menu.jsp" %>

</div><div class="container productContent">
		<div class="span6">
			<div class="hotProductCategory">
					<!-- 一级分类显示 -->
					<c:forEach items="${categoryList}" var="c">
						<dl>
							<dt>
								<a href="${pageContext.request.contextPath}/productfindByCid?cid=${c.cid }&page=1">${c.cname}</a>
							</dt>
								<!-- 二级分类显示 -->
								<c:forEach items="${c.categorySeconds}" var="cs">
									<dd>
										<a href="${pageContext.request.contextPath}/productfindByCsid?csid=${cs.csid}&page=1">${cs.csname }</a>
									</dd>
								</c:forEach>
						</dl>
						</c:forEach>
			</div>
			

		</div>
		<div class="span18 last">
			
			<div class="productImage">
					<a title="" style="outline-style: none; text-decoration: none;" id="zoom" href="${pageContext.request.contextPath}/${product.image}" rel="gallery">
						<div class="cloud-zoom">
						<img style="opacity: 1;" title="" class="medium" src="${pageContext.request.contextPath}/${product.image}">
						<div style="display: block; top: 0px; left: 162px; width: 0px; height: 0px; position: absolute; border-width: 1px;" class="zoomPup">
						</div>
						<div style="position: absolute; z-index: 5001; left: 312px; top: 0px; display: block;" class="zoomWindow">
						<div style="width: 368px;" class="zoomWrapper">
						<div style="width: 100%; position: absolute; display: none;" class="zoomWrapperTitle">
						</div>
						<div style="width: 0%; height: 0px;" class="zoomWrapperImage">
						<img src="${pageContext.request.contextPath}/${product.image}" style="position: absolute; border: 0px none; display: block; left: -432px; top: 0px;"/></div>
						</div></div><div style="visibility: hidden; top: 129.5px; left: 106px; position: absolute;" class="zoomPreload">Loading zoom</div></div>
					</a>
				
			</div>
			<div class="name">${product.pname}</div>
			<div class="sn">
				<div>编号：${product.pid}</div>
			</div>
			<div class="info">
				<dl>
					<dt>商城价:</dt>
					<dd>
						<strong>￥${product.shopPrice }</strong>
							参 考 价：
						<del>￥:${product.marketPrice}</del>
					</dd>
				</dl>
					<dl>
						<dt>促销:</dt>
						<dd>
								<a target="_blank" title="限时抢购 (2017-07-30 ~ 2018-01-01)">限时抢购</a>
						</dd>
					</dl>
					<dl>
						<dt>    </dt>
						<dd>
							<span>    </span>
						</dd>
					</dl>
			</div>
				<div class="action">
					
						<dl class="quantity">
							<dt>购买数量:</dt>
							<dd>
								<input id="count" name="count" value="1" maxlength="4" onpaste="return false;" type="text"/>
								
							</dd>
							<dd>
								件
							</dd>
						</dl>
					<div class="buy">
							<button id="addCart" class="addCart">加入购物车</button>
				
					</div>
				</div>
			<div id="bar" class="bar">
				<ul>
						<li id="introductionTab">
							<a href="#introduction">商品介绍</a>
						</li>
						
				</ul>
			</div>
				
				<div id="introduction" name="introduction" class="introduction">
					<div class="title">
						<strong>商品介绍</strong>
					</div>
					<div>
						${product.pdesc }
					</div>
				</div>
				
				
				
		</div>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="image\r___________renleipic_01/footer.jpg" alt="我们的优势" title="我们的优势" height="52" width="950">
</div>
</div>
	<div class="span24">
		<ul class="bottomNav">
					<li>
						<a href="#">关于我们</a>
						|
					</li>
					<li>
						<a href="#">联系我们</a>
						|
					</li>
					<li>
						<a href="#">诚聘英才</a>
						|
					</li>
					<li>
						<a href="#">法律声明</a>
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
						<a target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a >SHOP++官网</a>
						|
					</li>
					<li>
						<a>SHOP++论坛</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2005-2013 Mango商城 版权所有</div>
	</div>
</div>
</form>
</body>
</html>