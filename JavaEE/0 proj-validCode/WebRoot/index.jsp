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
	<script src="js/jquery.js" charset="utf-8" type="text/javascript"></script>
	<script type="text/javascript">
		$(function(){
			$("a").click(function(){
				// 浏览器有缓存功能，不会多次请求相同数据，所以加一个query，只要不同就会重新提交
				$("img").attr("src", "validcode?val="+Math.random());
				
				return false; // 取消a标签默认行为
			});
		});
	</script>
  </head>
  
  <body>
  	<form action="" method="post">
  		用户名：<input type="text" name="username" /><br/>
  		密码：<input type="password" name="password" /><br/>
  		验证码：<input type="text" size="1" />
  			<img width="80" height="40" src="validcode" />
  			<a href="#">看不清</a><br/>
  		<input type="submit" value="登录" />
  		<input type="reset" value="重置" />
  	</form>
  
	
  </body>
</html>











