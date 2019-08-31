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
    	需求分析：
    	1. 在当前页面内显示查询结果，考虑使用ajax
    	2. 创建ajax函数
    	3. 调用ajax函数发送请求到UserServlet
    	4. 调用业务层获取对应的数据
    	
     -->
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/ajaxUtil.js" charset="utf-8" type="text/javascript"></script>
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
							ta.innerHTML = "";
							
							// get result
							var result = ajax.responseText;
							if(result == "not found") {
								ta.innerHTML = result;
								return;
							}
							
							eval("var u = "+result); // 这样的好处：obj在jsp中，易读
							
							// dom operate
							var tr0 = ta.insertRow(0); // 在第二行插入row，首行是表头
							var cell0 = tr0.insertCell(0);
							var cell1 = tr0.insertCell(1);
							var cell2 = tr0.insertCell(2);
							var cell3 = tr0.insertCell(3);
							var cell4 = tr0.insertCell(4);
							cell0.innerHTML = "编号";
							cell1.innerHTML = "名称";
							cell2.innerHTML = "价格";
							cell3.innerHTML = "位置";
							cell4.innerHTML = "描述";
							
							var tr1 = ta.insertRow(1); // 在第二行插入row，首行是表头
							var cell0 = tr1.insertCell(0);
							var cell1 = tr1.insertCell(1);
							var cell2 = tr1.insertCell(2);
							var cell3 = tr1.insertCell(3);
							var cell4 = tr1.insertCell(4);
							cell0.innerHTML = u.uid;
							cell1.innerHTML = u.uname;
							cell2.innerHTML = u.price;
							cell3.innerHTML = u.loc;
							cell4.innerHTML = u.des;
							
						}
					}
					
				}
				
				// open, send. 通过UserServlet拿到db中数据
				ajax.open("get", "user?uname="+uname);
				ajax.send(null);
				
			}
	
			function getData2() {
				var uname = document.getElementById("uname").value;
				var data = "uname="+uname;
				myAjax("get", "user", data, function(ajax) {
					// status == 200
					// get result
					var result = ajax.responseText;
					eval("var u = "+result);
					console.log(u);
					
					// dom
					var ta = document.getElementById("ta");
					ta.innerHTML = "";
					
					var tr0 = ta.insertRow(0);
					var c0 = tr0.insertCell(0);
					var c1 = tr0.insertCell(1);
					var c2 = tr0.insertCell(2);
					var c3 = tr0.insertCell(3);
					var c4 = tr0.insertCell(4);
					c0.innerHTML = "编号";
					c1.innerHTML = "姓名";
					c2.innerHTML = "价格";
					c3.innerHTML = "位置";
					c4.innerHTML = "简介";
					
					var tr1 = ta.insertRow(1);
					var c0 = tr1.insertCell(0);
					var c1 = tr1.insertCell(1);
					var c2 = tr1.insertCell(2);
					var c3 = tr1.insertCell(3);
					var c4 = tr1.insertCell(4);
					c0.innerHTML = u.uid;
					c1.innerHTML = u.uname;
					c2.innerHTML = u.price;
					c3.innerHTML = u.loc;
					c4.innerHTML = u.des;
					
					
				});
				
				alert("haha");
			}
	</script>

  </head>
  
  <body>
    <h3>欢迎访问英雄商店</h3>
    <hr/>
   	英雄名称：<input type="text" name="uname" value="" id="uname" />
   			<input type="button" value="search" onclick="getData2()" />
   	<hr/>
   	
   	<table id="ta" border="1px" cellspacing="0px">
   	
   	</table>
    
  </body>
</html>













