<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	<!-- 使用 绝对路径，防止因为 请求转发 产生路径问题 -->
	<script src="/student2/js/jquery.js" charset="utf-8" type="text/javascript"></script>
	<script type="text/javascript">
		$(function(){
			var pageSize = "${pageinfo.pageSize}";			
			var pageNumber = "${pageinfo.pageNumber}";
			var tname = "${pageinfo.tname}";
			var sname = "${pageinfo.sname}";
			var total = "${pageinfo.total}";
			
			$.each($(":radio"), function(i, valDom){
				if( $(valDom).val() == pageSize ) {
					$(valDom).attr("checked", "checked");
				}
			});
			
			// 对输入框设置值
			$(":text[name='sname']").val(sname); // 表单选择器+属性选择器
			$(":text[name='tname']").val(tname);
			
			// 查询按钮 点击事件，pageNumber=1即从头开始显示
			$("button").click(function(){
				location.href = "show?pageSize="+pageSize
						+"&pageNumber="+1
						+"&sname="+$(":text[name='sname']").val()
						+"&tname="+$(":text[name='tname']").val();
			});

			
			// 单选按钮 选择pageSize 点击事件
			$(":radio").click(function(){
				pageSize = $(this).val();
				
				// 点击按钮，pageNumber=1
				location.href = "show?pageSize="+pageSize
					+"&pageNumber="+1
					+"&sname="+$(":text[name='sname']").val()
					+"&tname="+$(":text[name='tname']").val();
			});
			
			// prev, next
			$(".page_a:eq(0)").click(function(){
				pageNumber = parseInt(pageNumber) -1; // 字符串要转成int
				if(pageNumber <= 1){
					pageNumber = 1;
				}
				
				location.href = "show?pageSize="+pageSize
					+"&pageNumber="+pageNumber
					+"&sname="+$(":text[name='sname']").val()
					+"&tname="+$(":text[name='tname']").val();
				
				return false; // 取消超链接默认行为
			});
			$(".page_a:eq(1)").click(function(){
				pageNumber = parseInt(pageNumber) + 1;
				if(pageNumber >= total){
					pageNumber = total;
				}
				
				location.href = "show?pageSize="+pageSize
					+"&pageNumber="+pageNumber
					+"&sname="+$(":text[name='sname']").val()
					+"&tname="+$(":text[name='tname']").val();
				
				return false;
			});
			
			
			
		});
	</script>
	
  </head>
  
  <body>
  	每页显示几条：
  	<input type="radio" name="pageSize" value="2" />2 &nbsp;&nbsp;
  	<input type="radio" name="pageSize" value="4" />4 &nbsp;&nbsp;
  	<input type="radio" name="pageSize" value="6" />6 &nbsp;&nbsp; <br/>
  	
  	学生姓名：<input type="text" name="sname" />
  	老师姓名：<input type="text" name="tname" />
  	<button>search</button>

	<br/><br/>
	<table border="1" cellspacing="0">
		<tr>
			<td>ID</td>
			<td>学生姓名</td>
			<td>年龄</td>
			<td>任课老师</td>
		</tr>
		<c:forEach items="${pageinfo.list }" var="stu">
			<tr>
				<td>${stu.id }</td>
				<td>${stu.name }</td>
				<td>${stu.age }</td>
				<td>${stu.teacher.name }</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="" class="page_a">prev</a>
	<a href="" class="page_a">next</a>
    
  </body>
</html>













