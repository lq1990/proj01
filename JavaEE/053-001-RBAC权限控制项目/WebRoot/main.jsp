<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>main</title>
    
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
		// ajax实现加载
		$(function(){
			$.post("getMenu", function(data) {
				var result = "";
				
				for(var i=0; i<data.length; i++) {
					result += "<dl>";
					
					result += "<dt>"+data[i].name+"</dt>";
					for(var j=0; j<data[i].children.length; j++){
						result += "<dd>"+data[i].children[j].name+"</dd>";
					}
					
					result += "</dl>";
				}
				
				$("body").html(result);
				
			})
			
		});
	</script>

  </head>
  
  <body>
    
	
    
    
  </body>
</html>
