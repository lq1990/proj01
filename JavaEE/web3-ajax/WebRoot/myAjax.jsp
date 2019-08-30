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
			// 当点击button时，执行这个fn。由ajax发起req，server调用执行的servlet 再响应
			
			// 创建ajax引擎对象
			var ajax;
			if(window.XMLHttpRequest) {
				ajax = new XMLHttpRequest();
			} else if(window.ActiveXObject) { // ie67
				ajax = new ActiveXObject("Msxml2.XMLHTTP");
			}
			
			// 复写 onreadystatement函数
			// readyState值:
				// 0: XMLHttpRequest对象建立，但未初始化，未open
				// 1: open了，未send
				// 2：send了，其它数据未知
				// 3： 请求发送成功，正在接受数据
				// 4：成功接受响应数据完毕
			ajax.onreadystatechange = function() {
				// 判断ajax状态码
				if(ajax.readyState == 4) {
					// 接收到全部响应数据后，判断下 resp status code
					if(ajax.status == 200) {
						var result = ajax.responseText;
						alert(result);
						// get elem
						var div = document.getElementById("showdiv");
						div.innerHTML = result;
					} else if(ajax.status == 404) {
						var div = document.getElementById("showdiv");
						div.innerHTML = "请求资源不存在";
					} else if(ajax.status == 500) {
						var div = document.getElementById("showdiv");
						div.innerHTML = "服务器繁忙";
					} 
				} else {
					// 当响应资源还没到达前，loading...
					var div = document.getElementById("showdiv");
					div.innerHTML = "<img style='margin-left: 50px;' height='100px' width='100px' src='img/t.gif' />";
					
				}
			}
			
			// 发送请求
			ajax.open("get", "ajax"); // 第二个参配置 server需要调用的servlet
			ajax.send(null);
			alert("haha")
			
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



















