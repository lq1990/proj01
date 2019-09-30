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
	
	文件下载：<br/>
	
	直接请求:
	<a href="files/show.rar">show.rar</a>
	<a href="files/a.txt">a.txt</a>
	
	<br/>
	通过控制器：
	<a href="download?file=a.txt">下载</a>
	
	<hr/>
	
	
	文件上传：<br/>
	<!-- 若想在form上传文件，必须设置enctype="multipart/form-data"，且是post请求 -->
	<form action="upload" enctype="multipart/form-data" method="post">
		username: <input type="text" name="username" />
		file: <input type="file" name="file" />
		
		<input type="submit" value="提交" />
	</form>
	
	
  </body>
</html>












