<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
	JSTL学习：
		作用：
			提高在jsp中的逻辑代码的编写效率，使用标签。
		使用：
			JSTL的核心标签库（重点）
			JSTL的格式化标签库
			JSTL的SQL标签库
			JSTL的函数标签库
			JSTL的XML标签库
		JSTL的核心标签库：
			1. 导入jar包
			2. 声明jstl标签库的引入（核心标签库）
				<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			3. 内容：
				基本标签：
					<c:out value="数据 或 EL" default="可以设置默认值" ></c:out>
						作用：将数据输出给客户端
					<c:set var="" value="" scope=""></>
						作用：存储数据到作用域对象中
						var：表示存储的键名
						value：表示存储的数据
						scope：表示要存储的作用域对象 page/request/session/application
					<c:remove var="" scope="" />			
						作用：删除作用域中的指定键的数据
						var： 要删除的键的名字
						scope：要删除的作用域，可选。默认是删除所有4个作用域
				
				逻辑标签：
					  单分支：注意由于EL中数据必须在 作用域中，用到变量必须在作用域中set
						<c:if test="${EL逻辑表达式}" >
							前端代码
						</c:if>
					
					  多分支：类比于 if/ else if/ else
					  <c:choose>
					  	<c:when test="%{EL}">前端代码</c:when>
					  	<c:when test="">前端代码</c:when>
						<c:otherwise>前端代码</c:otherwise>			  
					  </c:choose>
				
				循环标签：[begin, end]
					<c:forEach begin="" end="" step="" varStatus="vs">
						循环体
					<c:forEach>
					使用：
						begin起始、end包含结束、step步长
						varStatus: 声明变量记录每次循环的数据（${vs.index}, vs.count, vs.first, vs.last）
							注意：数据存储在作用域中，需要使用EL表达式获取
						items: 声明要遍历的对象。结合EL获取对象。
						var：每次循环的结果 var var=result，结果存在作用中，使用EL获取
						
				
			
 --%>

<%
	request.setAttribute("str", "今天天气不错！");

%>
<!-- ============================================================== -->
<hr/>
<h3>基本标签学习：</h3>
输出语句：<br/>
<c:out value="哈哈"></c:out> 等价于直接写：哈哈 <br/>
<c:out value="${str }"></c:out> <br/>
<c:out value="${str2 }" default="嘿嘿"></c:out>
 
<br/><br/>
往作用域set kv，可以设置具体的scope<br/>
 <c:set var="hello" value="hello pageContext" scope="page"></c:set>
 <c:set var="hello" value="hello request" scope="request"></c:set>
 <c:set var="hello" value="hello session" scope="session"></c:set>
 <c:set var="hello" value="hello application" scope="application"></c:set>
 <c:out value="${hello }"></c:out> <br/>
 
指定作用域查找：<br/>
 <c:out value="${requestScope.hello }"></c:out> <br/>
 
<br/>
删除属性：<br/>
指定作用域删除 <c:remove var="hello" scope="page"/>
默认全删所有作用域: <c:remove var="hello"/>
<c:out value="${hello }" ></c:out> <br/>
<c:out value="${requestScope.hello }" ></c:out> <br/>
<c:out value="${sessionScope.hello }" ></c:out> <br/>
<c:out value="${applicationScope.hello }" ></c:out> <br/>
 
 <!-- =================================================================== -->
 <hr/>
 <h3>逻辑标签学习：</h3>
 传统方式：<br/>
 <%
 	int a = 4;
 	if(a>3) {
 %>
<b>今天的天气有点热！</b> 
 <%} %>
 
 jstl方式, test中判断条件使用EL，但EL用到的变量必须在 作用域中：<br/>
 
单分支：<br/>
 <c:set var="a" value="4"></c:set>
 <c:if test="${a>3 }">
 	<b>天气好啊！</b>
 </c:if>
 
 <br/><br/>
 多分支：<br/>
 <c:set var="score" value="85" ></c:set>
 <c:choose>
 	<c:when test="${score >= 90 }">
 		<i>奖励吃鸡装备一套</i>
 	</c:when>
 	<c:when test="${score >=80  }">
 		<i>奖励空投箱</i>
 	</c:when>
 	<c:when test="${score >= 70 }">
 		无奖励无惩罚
 	</c:when>
 	<c:otherwise>
 		<i>惩罚</i>
 	</c:otherwise>
 </c:choose>
 
 <!-- ============================================================= -->
 <hr/>
 <h3>JSTL的循环标签</h3>
 传统方式的表格：<br/>
 <table border="1px" cellspacing="0">
 	<tr>
 		<td>课程名称</td>
 		<td>教师</td>
 		<td>价格</td>
 		<td>重要性</td>
 	</tr>
 	
 	<% 
 		for(int i=0; i<3; i++){
 	%>
 	<tr>
 		<td>java</td>
 		<td>张</td>
 		<td>99</td>
 		<td>5</td>
 	</tr>
 	
 	<%} %>
 	
 </table>
 
 <br/><br/>
 使用JSTL方式：常量循环<br/>
 <c:forEach begin="0" end="3" step="1" varStatus="vs">
 	${vs.index } --- ${vs.count } --- ${vs.first } --- ${vs.last } ---
 	123 [begin, end] <br/>
 	vs可以记录角标，次数，是否是第一个，是否是最后一次
 	结果存在EL表达式中
 </c:forEach>
 
 <br/><br/>
 使用循环遍历一个list：<br/>
 <%
 	ArrayList<String> list = new ArrayList<String>();
 	list.add("aaa");
 	list.add("bbb");
 	list.add("ccc");
 	
 	HashMap<String, String> map = new HashMap<String, String>();
 	map.put("a1", "haha");
 	map.put("a2", "hehe");
 	map.put("a3", "xixi");
 	map.put("a4", "hengheng");
 	
 	request.setAttribute("list", list);
 	request.setAttribute("map", map);
 	
 	
 %>
 
 <c:forEach items="${list }" var="val">
 	${val } <br/>
 </c:forEach>
 注意：var中存的是 value，使用EL获取
 
 
 <br/>
 <c:forEach items="${list }" var="s">
 	<tr>
 		<td>${s }</td>
 		<td>anna</td>
 		<td>bj</td>
 	</tr>
 	<br/>
 </c:forEach>
 
 <br/>
 遍历map：<br/>
 <c:forEach items="${map }" var="m">
 	${m } -- ${m.key } -- ${m.value }<br/>
 </c:forEach>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 