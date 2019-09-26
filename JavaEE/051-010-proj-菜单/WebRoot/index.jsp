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
	<script type="text/javascript" src="js/jquery.js" charset="utf-8"></script>
	<script type="text/javascript">
		$(function(){
			$.post("show", function(data){
				var res = "";
				for(var i=0; i<data.length; i++) {
					res += "<dl>";
					
					res += "<dt style='cursor:pointer'>"+ data[i].name +"</dt>";
					for(var j=0; j<data[i].children.length; j++) {
						res += "<dd style='cursor:pointer'>"+data[i].children[j].name+"</dd>";
					}
					
					res += "</dl>";
				}
				
				$("body").html(res);
			});
			
			// 对所有父菜单添加点击事件，使用动态绑定 live。此处不能使用 $().click()
			$("dt").live("click", function(){
				// slow normal fast 数值
				$(this).siblings().slideToggle(100);
			});
			
			
		});
	</script>
  </head>
  
  <body>


  </body>
</html>















