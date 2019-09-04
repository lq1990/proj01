<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'my.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="" charset="utf-8" type="text/javascript"></script>
	<script type="text/javascript">
		function getData() {
			// 创建ajax引擎对象
			var ajax;
			if(window.XMLHttpRequest) {
				ajax = new XMLHttpRequest();
			} else if(window.ActiveXObject) { // ie67
				ajax = new ActiveXObject("Msxml2.XMLHTTP");
			}
			
			// 复写 onreadystatement函数
			ajax.onreadystatechange = function() {
				var result = ajax.responseText;
				
				// get elem
				var div = document.getElementById("showdiv");
				div.innerHTML = result;
				
			}
			
			// 发送请求
			ajax.open("get", "ajax");
			ajax.send(null);
			
		}
		
	</script>

	<style type="text/css">
		#showdiv {
			border: solid 1px;
			width: 200px;
			height: 100px;
		}
	</style>
  </head>
  
  <body>
    <h3>欢迎登录我的世界</h3>
    <hr/>
    <input type="button" value="测试" onclick="getData()"  />
    <div id="showdiv">
    
    </div>
  </body>
</html>



















