<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'log.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <!-- 显示 PageInfo中数据 -->
    <table border="1" cellspacing="0">
    	<tr>
    		<th>转账账户</th>
    		<th>收款账户</th>
    		<th>金额</th>
    	</tr>
    	<c:forEach items="${pageinfo.list }" var="log">
    		<tr>
    			<td>${log.accOut }</td>
    			<td>${log.accIn }</td>
    			<td>${log.money }</td>
    		</tr>
    	</c:forEach>
    </table>
    
    <!-- EL 用 $, 区分于 mapper.xml中 # -->
    <a href="show?pageSize=${pageinfo.pageSize}&pageNumber=${pageinfo.pageNumber-1}"
    	<c:if test="${pageinfo.pageNumber <= 1 }">
    		onclick="javascript:return false;"
    	</c:if>
    >
    	prev
    </a>
    <a href="show?pageSize=${pageinfo.pageSize}&pageNumber=${pageinfo.pageNumber+1}"
    	<c:if test="${pageinfo.pageNumber >= pageinfo.total }">
    		onclick="javascript:return false;"
    	</c:if>
    >
    	next
    </a>
  </body>
</html>















