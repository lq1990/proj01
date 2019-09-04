<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajaxData.jsp' starting page</title>
    <!-- 
    	xml格式 实现 servlet和js之间数据流转
    	
     -->
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
			function getData() {
				// get userdata
				var uname = document.getElementById("uname").value;
				
				// ajax obj
				var ajax;
				if(window.XMLHttpRequest) {
					ajax = new XMLHttpRequest();
				} else if(window.ActiveXObject) {
					ajax = new ActiveXObject("Msxml2.XMLHTTP");
				}
				
				// onreadystatechange
				ajax.onreadystatechange = function() {
					if(ajax.readyState == 4) {
						if(ajax.status == 200) {
							var ta = document.getElementById("ta");
							
							// get result
							//var result = ajax.responseText;
							var doc = ajax.responseXML; // 响应数据为xml格式
							console.log(result);
							
							
						}
					}
					
				}
				
				// open, send. 通过UserServlet拿到db中数据
				ajax.open("get", "user?uname="+uname);
				ajax.send(null);
				
			}
			
	
	</script>
	
	<style type="text/css">
		#showdiv {
			width: 200px;
			height: 100px;
			border: solid 1px;
		}
	</style>
  </head>
  
  <body>
    <h3>欢迎访问英雄商店</h3>
    <hr/>
   	英雄名称：<input type="text" name="uname" value="" id="uname" />
   			<input type="button" value="search" onclick="getData()" />
   	<hr/>
   	
   	<table id="ta" border="1px" cellspacing="0px">
   	
   	</table>
   	
   	<div id="showdiv"></div>
    
  </body>
</html>













