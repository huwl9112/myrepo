<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="span24">
		<ul class="mainNav">
					<li>
						<a href="${ pageContext.request.contextPath }/index">首页</a>
						|
					</li>
					<c:forEach items="${sessionScope.categoryList}" var="category">
						<li>
							<a href="${ pageContext.request.contextPath }/productfindByCid?cid=${category.cid}&page=1">${category.cname}</a>
							|
						</li> 
					</c:forEach>
		</ul>
	</div>