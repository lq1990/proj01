<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajaxReqMethod.jsp' starting page</title>
    
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
			var pwd = document.getElementById("pwd").value;
			
			// 1. ajax对象
			var ajax;
			if(window.XMLHttpRequest) {
				ajax = new XMLHttpRequest();
			} else if (window.ActiveXObject) {
				ajax = new ActiveXObject("Msxml2.XMLHTTP");
			}
			
			// 2. 复写onreadystatechange
			ajax.onreadystatechange = function() {
				// ajax.readyState
				if(ajax.readyState == 4) {
					if(ajax.status == 200) {
						var result = ajax.responseText; // 响应文本
						
						var div = document.getElementById("showdiv");
						div.innerHTML = result;
					} else {
						var result = ajax.responseText;
						
						var div = document.getElementById("showdiv");
						div.innerHTML = result;
					}
					
				} else {
					var div = document.getElementById("showdiv");
					div.innerHTML = "<img src='img/t.gif' style='height: 100px;width:100px; margin-left:50px;' />";
				}
				
			}
			
			// 3. open, send
			// get
			//ajax.open("get", "ajax?uname="+uname+"&pwd="+pwd);
			//ajax.send(null);
			// post
			ajax.open("post", "ajax");
			ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			// 使server知道解析格式。 和form中 enctype一致。
			ajax.send("uname=anna&pwd=21");
			
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
    <h3>ajax请求方式</h3>
    <hr/>
    uname: <input type="text" name="uname" id="uname" value="" /> <br/>
    pwd:   <input type="password" name="pwd" id="pwd" value="" /> <br/>
    <input type="button" value="测试请求" onclick="getData()" /> 
    <br/>
    <div id="showdiv">
    	
    </div>
    
    
    <form action="" method="" enctype="application/x-www-form-urlencoded"></form>
    <!-- 默认的 enctype -->
    
  </body>
</html>











