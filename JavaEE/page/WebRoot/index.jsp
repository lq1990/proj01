<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	.a {
		text-align: center;
	}
</style>
	
</head>

<body>
	<div>
		<table border="1" cellspacing="0" align="center">
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>年龄</th>
			</tr>
			<c:forEach items="${PageInfo.list }" var="p">
				<tr>
					<td>${p.id }</td>
					<td>${p.name }</td>
					<td>${p.age }</td>
				</tr>
			</c:forEach>
		</table>
		<div class="a">
			<a href="show?pageNumber=${PageInfo.pageNumber-1 }&pageSize=${PageInfo.pageSize}" 
				<c:if test="${PageInfo.pageNumber <= 1}">
					onclick="javascript:return false;"
				</c:if>
			>
				<!-- 此处使用 javascript: 行内写法， return false可以使默认行为失效 -->
				上一页
			</a>
			
			<a href="show?pageNumber=${PageInfo.pageNumber+1 }&pageSize=${PageInfo.pageSize}" 
				<c:if test="${PageInfo.pageNumber >= PageInfo.total}">
					onclick="javascript:return false;"
				</c:if>
			>
				下一页
			</a>
		</div>
	</div>

</body>
</html>











