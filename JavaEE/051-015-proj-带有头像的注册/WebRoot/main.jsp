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
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery.js" charset="utf-8"></script>
	<script type="text/javascript">
		$(function(){
			$("a").click(function(){
				// parent()父标签，prev()前一个兄弟标签，
				// jquery命名规范：对象名以$开头
				var $td = $(this).parent().prev();
				$td.html(parseInt($td.html()) + 1);
				
			});
		});
	</script>
	
  </head>
  
  <body>
    <table border="1" cellspacing="0">
    	<tr>
    		<td>资料名称</td>
    		<td>下载次数</td>
    		<td>操作</td>
    	</tr>

		<c:forEach items="${list }" var="file">
			<tr>
				<td>${file.name }</td>
				<td>${file.count }</td>
				<td><a href="download?id=${file.id}&name=${file.name}">下载</a></td>
			</tr>
		</c:forEach>
    </table>
    
  </body>
</html>










