<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <form action="demo6" method="post">
    	<!--
    	name: <input type="text" name="name" /> <br/>
    	age: <input type="text" name="age" /> <br/>
    	<input type="checkbox" name="hover" value="学习" />
    	<input type="checkbox" name="hover" value="代码" />
    	<input type="checkbox" name="hover" value="视频" />
    	<input type="checkbox" name="hover" value="笔记" />
    	 -->
    	 
    	 <input type="text" name="peo[0].name" />
    	 <input type="text" name="peo[0].age" />
    	 <input type="text" name="peo[1].name" />
    	 <input type="text" name="peo[1].age" />
    	
    	<input type="submit" value="提交" />
    	
    	<a href="demo7?age=123&name=abc">link-demo7</a>
    	<a href="demo8/1234/abc2">link2-demo8</a>
    	
    </form>
  </body>
</html>












