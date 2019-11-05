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
    
    <title>众筹平台</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body {
			background-color: #f8f8f8;
		}
	
		.head {
			color: white;
			font-size: 24px;
			font-weight: bold;
			line-height: 36px;
			background-color: gray;
		}
		.head-user {
			font-size: 16px;
			position: absolute; 
			right:100px; 
			background-color: #44d39f;
			border-left: 5px solid #44d39f;
			border-right: 5px solid #44d39f;
		}
		.head-out {
			font-size: 16px;
			position: absolute; 
			right:30px; 
		}
		
		.left {
			width: 30%;
			height: 100%;
			background-color: white;
		}
		
		.head a {
			text-decoration: none;
			color: white;
		}
		
		dt, dd {
			font-size: 18px;
			line-height: 30px;
		}
		
		.left a {
			text-decoration: none;
			color: black;
		}
		
		
	</style>

  </head>
  
  <body>
	 <div class="head">
	 	<span>
			 控制面板
	 	</span>
	 	<span class="head-user">
	 		${loginUser.loginacct }
	 	</span>
	 	<span class="head-out">
	 		<a href="logout">退出</a>
	 	</span>
		 
	 </div> 
	 
	 <div class="left">
	 	<dl>
	 		<dt style="font-weight:bold;">权限管理</dt>
	 		<dd><a href="">用户维护</a></dd>
	 		<dd><a href="">角色维护</a></dd>
	 		<dd><a href="">许可维护</a></dd>
	 	</dl>
	 </div>
	 
	 
    
    
  </body>
</html>
