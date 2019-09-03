<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	
	<script src="js/jquery.js" charset="utf-8" type="text/javascript"></script>
	<script type="text/javascript">
		//  页面加载完成后执行，相当于 window.onload=functin(){}, $(document).ready(function(){})
		$(function(){
			$("form").submit(function(){
				// 表单选择器
				if($(":text:eq(0)").val() == "" 
						|| $(":text:eq(1)").val() == "" 
						|| $(":text:eq(2)").val() == "" ) {
					alert("请填写完整信息");
					// 阻止默认行为。
					return false;
				}
			});
		});
	
	</script>

  </head>
  
  <body>
  	<!-- 
  		post: 
  			字节流
  			max 2GB
  			更安全，效率较低
  		get：
  			字符流
  			2KB
  	 -->
	  <form method="post" action="insert" >
	    <table border="1" align="center"> <!-- table加align 会使table相对于父居中 -->
	    	<tr>
	    		<td colspan="2" style="text-align:center;font-size:30px;font-weight:bold;">
	    			花卉信息
	    		</td>
	    	</tr>
	    	<tr>
	    		<td><b>花卉名称:</b></td>
	    		<td><input type="text" name="name" /></td>
	    	</tr>
	    	<tr>
	    		<td><b>花卉价格:</b></td>
	    		<td><input type="text" name="price" /></td>
	    	</tr>
	    	<tr>
	    		<td><b>原产地:</b></td>
	    		<td><input type="text" name="production" /></td>
	    	</tr>
	    	<tr>
	    		<td colspan="2" align="center">
	    			<input type="submit" value="提交" />
	    			<input type="reset" value="重置" />
	    		</td>
	    	</tr>
	    </table>
	  </form>
	  
  </body>
</html>












