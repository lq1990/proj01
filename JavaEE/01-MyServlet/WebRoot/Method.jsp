<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Method.jsp' starting page</title>
    
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
    This is my JSP page. <br>
    
    <form action="req" method="get">
    	<!-- action的url是相对路径，相对当前项目目录 -->
    	用户名: <input type="text" name="uname" value="" />
    	密码: <input type="password" name="pwd" value="" />
    	爱好: 
    	<input type="checkbox" name="fav" value="1" />singing
    	<input type="checkbox" name="fav" value="2" />dancing
    	<input type="checkbox" name="fav" value="3" />reading
    	
    	<input type="submit" value="登录" />
    </form>
  </body>
</html>
