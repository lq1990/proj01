<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>登录页面</title>
    <meta charset="utf8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body {
			background-color: #f8f8f8;
		}
		input, select {
			margin: 3px 0px;
		}
		
	</style>
	<script type="text/javascript" src="${APP_PATH }/js/jquery-1.9.1.js" charset="utf8"></script>
	<script type="text/javascript" src="${APP_PATH }/layer/layer.js" charset="utf8"></script>
	
	<script type="text/javascript" charset="utf8">
		function dologin() {
			// 非空校验
			var loginacct = $("#loginacct").val();
			// 表单元素的value取值不会为null，取值为 空字符串""
			
			if(loginacct == "") {
				layer.msg("用户登录账号不能为空，请输入！", {time:2000, icon:5, shift:5}, function(){
				});
				return;
			}
			
			var pwd = $("#pwd").val();
			if(pwd == "") {
				layer.msg("用户的登录密码不能为空，请输入！", {time:2000, icon:5, shift:5}, function(){
				});
				return;
			}
			
			// 提交表单
			//$("#loginForm").submit(); // 使用ajax替代这个，可以防止页面闪烁
			var loadingIndex = null;
			
			// ajax中data是向server传递的param，success是server的响应
			$.ajax({
				type: "POST",
				url: "doAJAXLogin",
				data: {
					"loginacct": loginacct,
					"pwd": pwd
				},
				beforeSend: function(){
					loadingIndex = layer.msg("处理中", {icon:16});
				},
				success: function(result){
					layer.close(loadingIndex);
					if(result.success){
						window.location.href = "main";
					}else {
						layer.msg("登录账号或密码不正确，请重新输入！", {time:2500, icon:5, shift:5}, function(){
						});
					}
				}
			});
		}
	</script>

  </head>
  
  <body>
  	<div>
  		<h1 style="color:red;">${param.errorMsg}</h1>
    	<form id="loginForm" action="dologin" method="post" style="margin-left:50px;">
    		<h2>用户登录</h2>
    		<input type="text" name="loginacct" id="loginacct" placeholder="请输入登录账号" /> <br/>
    		<input type="password" name="pwd" id="pwd" placeholder="请输入登录密码" /> <br/>
    		<select>
				<option value="member">会员</option>
				<option value="user">管理</option>
    		</select> <br/>
    		<input type="checkbox" name="remember" />记住我 <a href="">忘记密码</a><br/>
    		<a href="reg.html">注册</a>
    		<a onclick="dologin()" 
    			style="color:white;background-color:#44d39f;border: 1px solid #44d39f;cursor:pointer;" >
    			登录</a>
    	
    	</form>
  	</div>
    	
    
  </body>
</html>
