<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- @指令 --%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
		a {
			color: black;
			text-decoration: none;
		}
		a:hover {
			color: red;
		}
	</style>
  </head>
  
  <body>
    <table border="1">
    	<tr>
    		<th>花卉编号</th>
    		<th>花卉名称</th>
    		<th>价格（元）</th>
    		<th>原产地</th>
    	</tr>
    	<c:forEach items="${list }" var="flower">
    		<tr>
    			<td>${flower.id }</td>
    			<td>${flower.name }</td>
    			<td>${flower.price }</td>
    			<td>${flower.production }</td>
    		</tr>
    	</c:forEach>
    </table>
    
    <a href="add.jsp">添加花卉信息</a>
    
  </body>
</html>



















