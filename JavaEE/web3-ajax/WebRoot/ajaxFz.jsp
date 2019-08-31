<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajaxFz.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	
		/*
			method: get | post
			url:
			data:
			
		*/
		function myAjax(method, url, data, deal200, deal404, deal500, async) {
			// ajax
			var ajax = getAjax();
			
			// onreadystatechange
			ajax.onreadystatechange = function() {
				// readyState
				if(ajax.readyState == 4) {
					// status
					if(ajax.status == 200) {
						if(deal200) {
							deal200(ajax);
						}
					} else if(ajax.status == 404) {
						if(deal404) {
							deal404(ajax);
						}
					} else if(ajax.status == 500) {
						if(deal500) {
							deal500(ajax);
						}
					}
				} 
			}
			
			if(async == null) {
				async = true;
			}
			
			// open, send
			if(method == "get") {
				ajax.open(method, url+(data==null ? "": "?"+data), async);
				ajax.send(null);
			} else if(method == "post") {
				ajax.open(method, url, async);
				ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				ajax.send(data);
			} else {
				
			}
			
		}
		
		function getData(){
			myAjax("get", "ajax", null, true, function(ajax) {
				// result
				var result = ajax.responseText;
				// dom
				var div = document.getElementById("showdiv");
				div.innerHTML = result;
			})
		} 
		
		/* ------------------------------ */
		function getAjax() {
			var ajax;
			if(window.XMLHttpRequest) {
				ajax = new XMLHttpRequest();
			} else if(window.ActiveXObject) {
				ajax = new ActiveXObject();
			}
			
			return ajax;
		}
		
	</script>
	
	<style type="text/css">
		#showdiv {
			width: 200px;
			height: 200px;
			border: solid 1px;
		}
	</style>

  </head>
  
  <body>
    This is my ajaxFz page. <br>
    
    <input type="button" value="getData" onclick="getData()" />
    <div id="showdiv"></div>
    
  </body>
</html>













