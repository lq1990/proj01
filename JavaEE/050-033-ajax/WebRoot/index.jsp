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
			
			// 点击a标签时，ajax异步请求demo
			// url，data 请求的参数，dataType 服务器返回数据类型, 
			// error请求出错执行的功能, success: 请求成功200状态码时执行 function中参数是响应数据
			// type: 请求方式
			$("a").click(function(){
				$.post("demo", {"name":"anna"}, function(res){
					var str = "";
					
					for(var i=0; i<res.length; i++){
						var row = res[i];
						
						str += "<tr>";
						str += "<td>"+row.id+"</td>";
						str += "<td>"+row.username+"</td>";
						str += "<td>"+row.password+"</td>";
						str += "</tr>";
					}
					
					// .html() 是先清空再添加
					$("#mytbody").html(str);
				} );

				
				return false; // 把a标签默认功能取消
			});
		});
	</script>
  </head>
  
  <body>
  	<!-- 超链接本质上是 两次访问：
  		第一次是预处理 是否允许访问、存不存在，server返回一个真实的资源路径；
  		第二次是真实的请求 -->
    <a href="demo">link to demo</a> <br/>
    <a href="imgs/village03.jpg">village</a>
    
    <hr/>
    <table border="1" cellspacing="0">
    	<tr>
    		<th>id</th>
    		<th>username</th>
    		<th>password</th>
    	</tr>
    	
    	<!-- 分组标签，thead,tbody,tfoot -->
    	<tbody id="mytbody"></tbody>
    </table>
  </body>
</html>





















