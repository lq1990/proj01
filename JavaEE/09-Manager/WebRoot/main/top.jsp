<%@page import="com.wendao.pojo.User"%>
<%@ page language="java" import="java.util.*,com.wendao.pojo.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	});
	
	// 动态绑定事件
	$("#out").click(function(){
		var flag = window.confirm("确定退出？");
		if(flag) {
			window.top.location.href = "user?oper=out"; //    /mg/user ，web.xml中引到 UserServlet
			// .top. 使得当前页面的上级页面进行 location
		}
	});
	
})	
</script>


</head>

<body style="background:url(images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="main.html" target="_parent"><img src="images/logo.png" title="系统首页" /></a>
    </div>
            
    <div class="topright">
        
    <ul>
    <li><a href="javascript:void(0)" id="out" target="_top" >退出</a></li>
    </ul>
     
    <div class="user">
    <span>
    	<%
    		User u = (User) session.getAttribute("user");
    		out.write(u.getUname());
    	%>
    </span>
    </div>    
    
    </div>

</body>
</html>









