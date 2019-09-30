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
			var username=false;
			var password=false;
			var passwordSure = false;
			
			// 用户名验证
			$(":text:eq(0)").blur(function(){
				if($(this).val() == "") {
					$(this).next().css("color","red").html("x");
					usename=false;
				} else {
					$(this).next().css("color","green").html("√");
					username=true;
				}
				
			});
			
			// 密码验证
			$(":password:eq(0)").blur(function(){
				// js中正则要求两侧//
				if(!$(this).val().match(/^\w{6,12}$/)) {
					$(this).next().css("color","red").html("x");
					password = false;
				} else {
					$(this).next().css("color","green").html("√");
					password = true;
				}
				
			});
			
			// 对确认密码验证
			$(":password:eq(1)").blur(function(){
				if($(this).val() == "" || $(this).val() != $(":password:eq(0)").val() ) {
					$(this).next().css("color","red").html("x");
					passwordSure = false;
				} else {
					$(this).next().css("color","green").html("√");
					passwordSure = true;
				}
				
			});
			
			// 头像, file表单时只读的所以：$(":file").val(不能设置值)
			
			
			// submit
			$(":submit").click(function() {
				if(username == false || password==false || passwordSure==false || $(":file").val()==""){
					alert("请填写完整信息");
					return false;
				}
				
			});
			
		});
	</script>
	
  </head>
  
  <body>
	<form action="register" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" /><span></span></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password" /><span></span></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type="password" name="passwordSure" /><span></span></td>
			</tr>
			<tr>
				<td>头像：</td>
				<td><input type="file" name="file" /></td>
			</tr>
			<tr>
				<td style="text-align:center;" colspan="2"><input type="submit" value="注册" /></td>
			</tr>
		</table>
		
	
	</form>    


  </body>
</html>

