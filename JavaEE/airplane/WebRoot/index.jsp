<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
  </head>
  
  <body>
     <!-- select中的值会 提交，在ShowAirplaneServlet中getParameter()取到 -->
	  <form action="showtake" method="get">
		    起飞机场：
		    <select name="takeid">
		    	<option value="0">请选择</option>
		    	<c:forEach items="${takeport}" var="take">
			    	<option value="${take.id }">${take.portname }</option>
		    	</c:forEach>
		    </select>
		    
		    &nbsp;
		    &nbsp;
		    降落机场：
		    <select name="landid">
		    	<option value="0">请选择</option>
		    	<c:forEach items="${landport}" var="land">
			    	<option value="${land.id }">${land.portname }</option>
		    	</c:forEach>
		    </select>
		    
		   <input type="submit" value="查询" />
	    
	 </form>
    
    <table border="1" cellspacing="0">
    	<tr>
    		<td>飞机编号</td>
    		<td>起飞机场</td>
    		<td>起飞城市</td>
    		<td>降落机场</td>
    		<td>降落城市</td>
    		<td>航行时间</td>
    		<td>票价（元）</td>
    	</tr>
    	
    	<c:forEach items="${listAirplane }" var="a">
    		<tr>
    			<td>${a.airno }</td>
    			<td>${a.takeport.portname }</td>
    			<td>${a.takeport.cityname }</td>
    			<td>${a.landport.portname }</td>
    			<td>${a.landport.cityname }</td>
    			<td>
    				<c:if test="${a.time/60.0 >= 1 }">
    					<fmt:formatNumber value="${a.time/60 }" pattern="0"></fmt:formatNumber>小时
    				</c:if>
    				<c:if test="${a.time%60 > 0 }">
    					${a.time%60 }分钟
    				</c:if>
    			</td>
    			<td>${a.price }</td>
    		</tr>
    	</c:forEach>
    	
    </table>
    
  </body>
</html>















