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
	<script src="/student/js/jquery.js" charset="utf-8" type="text/javascript"></script>
	<script type="text/javascript">
		$(function(){
			// EL表达式在jsp中被server解析，但若此js文件时外联的，则EL不会被serve人解析 直接发个client
			var pageSize = "${pageinfo.pageSize}"; // 加字符串：当EL中无值时，使得左式为""
			var pageNumber = "${pageinfo.pageNumber}";
			var tname = "${pageinfo.tname}";
			var sname = "${pageinfo.sname}";
			var total = "${pageinfo.total}";
			
			// 表单选择器
			// dom => jquery ?  $(dom对象)
			// jquery => dom ?  jquery对象[0] 或 jquery对象.get(0)
			$.each($(":radio"), function(i, valDom){
				if ($(valDom).val() == pageSize) {
					$(valDom).attr("checked", "checked");
				}
			});
			
			// 对输入框设置值
			$(":text[name='sname']").val(sname);
			$(":text[name='tname']").val(tname);
			
			// 查询按钮 点击事件
			$("button").click(function(){
				location.href="show?pageSize="
						+pageSize+"&pageNumber=1&tname="
					+$(":text[name='tname']").val()
					+"&sname="+$(":text[name='sname']").val();
			});
			
			// radio按钮的点击事件
			$(":radio").click(function(){
				pageSize = $(this).val();
				
				location.href="show?pageSize="
					+pageSize+"&pageNumber=1&tname="
				+$(":text[name='tname']").val()
				+"&sname="+$(":text[name='sname']").val();
			});
			
			// 点击上一页
			$(".page_a:eq(0)").click(function(){
				pageNumber = parseInt(pageNumber) - 1;
				if(pageNumber>=1){
					location.href="show?pageSize="
						+pageSize+"&pageNumber="+pageNumber
						+"&tname="
					+$(":text[name='tname']").val()
					+"&sname="+$(":text[name='sname']").val();
					
				} else {
					pageNumber = 1;
				}
				return false;
				
			});
			
			// 点击next
			$(".page_a:eq(1)").click(function(){
				pageNumber = parseInt(pageNumber) + 1;
				if(pageNumber <= total){
					location.href="show?pageSize="
						+pageSize+"&pageNumber="+pageNumber
						+"&tname="
					+$(":text[name='tname']").val()
					+"&sname="+$(":text[name='sname']").val();
					
				} else {
					pageNumber = total;
				}
				return false;
				
			});
			
			
		
		});
	</script>
  </head>
  
  <body>
  	每页显示几个: 
    <input type="radio" value="2" name="pageSize" />2 &nbsp;&nbsp;
    <input type="radio" value="3" name="pageSize" />3 &nbsp;&nbsp;
    <input type="radio" value="4" name="pageSize" />4 &nbsp;&nbsp; <br/><br/>
    学生姓名: <input type="text" name="sname" /> &nbsp;&nbsp;
   老师姓名: <input type="text" name="tname"/>
   <button>search</button>
   
   <hr style="color: #ff9645;"/>
   
   
   <table border="1" cellspacing="0">
   		<tr>
			<td>学生编号</td>   			
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























