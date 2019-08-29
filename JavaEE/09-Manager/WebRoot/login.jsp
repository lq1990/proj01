<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 

</head>

<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录后台管理界面平台</span>    
      
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
    <br/>
    
    <%
    	String info = "";
    	String color = "red"; 
    	// java代码。当db中没有此用户时，提示语
    	Integer flag = (Integer) request.getAttribute("flag");
    	if(flag != null && flag == 0) {
    		info = "用户名或密码错误";
    	}
    	
    	Integer pwd = (Integer) session.getAttribute("pwd");
    	if(pwd != null && pwd == 1) {
    		info = "密码修改成功";
    		color = "green";
    		session.removeAttribute("pwd"); // pwd用完后，移除。若不移除，则info会一直显示
    	}
    	
    	Integer reg = (Integer) session.getAttribute("reg");
    	if(reg != null && reg == 1) {
    		info = "注册成功，请登录!";
    		color = "green";
    		session.removeAttribute("reg"); // pwd用完后，移除。若不移除，则info会一直显示
    	}
    		
    %>
    
    
    <div class="loginbox loginbox1">
    
    <form action="user" method="post" >
    	<!-- action到的url在web.xml中配置 -->
    
    	<input type="hidden" name="oper" value="login" /> 
    	<!-- 给当前form添加一个隐藏input，当使用name拿到value时，可知这是login表单 -->
	    
	    <ul>
	    <!-- 提示语 -->
	    <span style='font-size: 12px; font-weight: bold; color: <%=color%>;'><%=info %></span>
	    <li><input name="uname" type="text" placeholder="用户名" class="loginuser" /></li>
	    <li><input name="pwd" type="password" placeholder="密码" class="loginpwd" /></li>
	    <li class="yzm">
	    <span><input name="" type="text" value="验证码" onclick="JavaScript:this.value=''"/></span><cite>X3D5S</cite> 
	    </li>
	    <li>
	    	<input name="" type="submit" class="loginbtn" value="登录"  onclick="javascript:window.location='main.html'"  />
	    	
	    	<label>
	    		<a href="user/reg.jsp" >注册</a>
	    	</label>
	    	<label><a href="#">忘记密码？</a></label></li>
	    </ul>
    </form>
    
    </div>
    
    </div>
    
    
    <div class="loginbm">版权所有  2019 文刀出品
      QQ：1111111
    </div>
	
    
</body>

</html>

