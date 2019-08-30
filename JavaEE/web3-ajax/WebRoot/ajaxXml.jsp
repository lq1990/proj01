<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajaxXml.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function getXML() {
			// ajax obj
			var ajax;
			if(window.XMLHttpRequest) {
				ajax = new XMLHttpRequest();
			} else if(window.ActiveXObject) {
				ajax = new ActiveXObject();
			}
			
			// onreadystatechange
			ajax.onreadystatechange = function() {
				// readyState
				if(ajax.readyState == 4) {
					// status
					if(ajax.status == 200) {
						// get result
						var doc = ajax.responseXML;// return 文档对象，可以进行dom操作
						console.log(doc.getElementsByTagName("uname"));
						console.log(doc.getElementsByTagName("uname")[0].innerHTML);
						
						// dom
						
					} else {
						
						
					}
				}
				
			}
			
			// open, send
			ajax.open("get", "xml");
			ajax.send(null);
			
		}
	</script>

  </head>
  
  <body>
    <h3>XML数据格式学习</h3>
    <hr/>
    <input type="button" value="test xml" onclick="getXML()" />
    
  </body>
</html>















