<%@ page language="java" import="java.util.*,java.lang.*" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@ page errorPage="error.jsp" %>
<%@ page isErrorPage="true" %>

<%-- 

	Jsp的三种注释：
		前端语言注释
			会被转译，发送，但不会被浏览器执行
		java语言注释
			会被转译，但不会被servlet执行
		Jsp注释
			不会被转译
		
	Jsp的page指令学习：
		<%@ 属性名="属性值" 属性名="属性值" 属性名="属性值" %>
		language 声明jsp要被转译的语言
		import 声明转译的java文件要导入的包，包之间用 , 隔开
		pageEncoding 设置jsp文件的数据编码格式，当保存该jsp时，文件的编码格式
		contentType="text/html;charset=utf-8" 设置jsp数据响应给浏览器时，浏览器的解析和编码格式。
		session="true/false" 设置转译的servlet中是否开启session支持，默认true开启
		errorPage 设置jsp运行错误跳转的页面。（运行错误）
		extends 设置jsp转译的java文件要继承的父类(包名+类名)
		作用总结：
			将jsp转为java文件，配置转译相关的参数。
	
	
	Jsp的局部代码块(被转译在 _jspService()中，在局部块中可以使用 全局块中定义的 类的方法和属性)：
		特点：
			局部代码块中声明的java代码会被原样转译到 jsp对应的servlet文件的 _jspService方法中，
			代码块中声明的变量都是局部变量。
		使用：
			<% java代码 %>
		缺点：
			使用局部代码块在jsp中进行逻辑判断，书写麻烦，阅读困难。
		开发中：
			在jsp中尽量不写逻辑代码。
			在servlet中写逻辑，把数据传给jsp 做页面展示。
			
	Jsp的全局代码块(被转译为java类的方法和属性)
		特点：
			声明的java代码作为全局代码转译到对应的servlet类中。
		使用：
			<%! 全局代码 %>
		注意：
			全局代码块声明的代码，需要使用局部代码块调用。
			
	Jsp的脚本段语句；<%=str%>
		等价于： <% out.write(str); %> 
		好处：方便获取变量或fn的返回值 作为数据响应给浏览器
		可使用的位置：除jsp语法要求以外的任意位置
		
	Jsp的静态引入、动态引入：
		两种显示效果一样。
		静态引入：
			<%@ include file="文件相对路径" %>
			特点：
				会将引入的jsp文件和当前jsp文件转译成一个java(Servlet)文件使用，
				在网页中也就显示了合并后的显示效果。
		
			注意：
				静态引入的jsp文件不会单独转移成Servlet文件
				两文件的声明变量名 不能冲突。
		
		动态引入：
			<jsp:include page="includeDyn.jsp"></jsp:include>
			特点：
				被引入的jsp文件单独转译，当前jsp引入 它转译文件。
			注意：
				两jsp中 可以同名变量，因为不同jsp文件是单独作用域。类似于不同的方法。
			
		优点：
			降低jsp代码的冗余，便于维护升级。
			
			
	Jsp的转发标签 forward
		使用：
			<jsp:forward page="jsp文件相对路径">
				<jsp:param value="" name="" />
			</jsp:forward>
		特点：
			一次请求
			url栏不改变
		注意：
			在转发标签的两个标签中间只能写
				<jsp:param value="val" name="key" />，其它内容会报错
				在forward.jsp中 <%=request.getParameter("key") %> 取出key对应的值
				相当于：把数据已？的形式拼接在转发路径的后面。
			
		
		
		
		
 --%>
 
 <!-- 
 	前端语言注释
  -->
 
 
 <%-- 
 	this is jsp comment.
 --%>

<html>
	<head>
		<title>jsp基本语法学习</title>
		<meta charset="utf-8" />
	</head>
	
	<body>
		<h3>学习</h3>
		<hr />
		
		<!-- 局部代码块 -->
		<%
			// 声明java代码块
			String str = "jsp中使用逻辑校验很难受。";
			int a = 0;
			if(a>3) {
				
		%>
		
			<b>jsp学习简单</b>
		
		<%
			} else {
			test();
		%>
			<i><% out.write(str); %></i>
			<br />等价于：<br />
			<i><%=str%></i> 
		
		<% } %>
		
		
		<!-- 全局代码块，用于书写 fn 和全部变量 -->
		<%! 
			int b = 5;
			public void test() {
				System.out.println("我是全局代码块");
			}
		%>
		
		<!-- jsp的静态引入，静态被引入的文件会被合并，执行的是合并后的文件-->
		<%@ include file="includeStatic.jsp" %>
		
		<!-- jsp的动态引入 -->
		<jsp:include page="includeDyn.jsp"></jsp:include>
		
		<!-- 重定向 -->
		<%
			// response.sendRedirect("forward.jsp");
		%>
		
		
		<!-- jsp的转发 forward标签，uri不会改 -->
		<%--
		jsp comment
		
		<jsp:forward page="forward.jsp">
			<jsp:param value="aaa" name="str"/>
		</jsp:forward>
			
			 forward?str=aaa 
			
		 --%>
		
		
		<!-- jsp的九大内置对象学习 -->
		<%
			String s = (String) request.getParameter("str"); // getParameter() 是拿到 url中?后面即query参数
			// http://localhost:8080/jsp/jspPro.jsp?str=123
		%>
		s: 
		<%=s %>
		
		<hr/>
		<!-- jsp的路径 -->
		<a href="a/a.jsp" >a</a>
		<br/>
		<a href="a/b/b.jsp" >b</a>
		
		
		
	</body>
</html>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 