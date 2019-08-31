<%@page import="com.wendao.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*" pageEncoding="UTF-8"%>

<!-- 使用传统方式获取作用域对象的数据 -->
<h3>使用传统方式获取作用域对象的数据</h3>
<b><%=request.getParameter("uname") %></b>
<b><%=request.getParameter("pwd") %></b><br/>
<b><%=request.getAttribute("str") %></b><br/>

<%
	User u = (User) request.getAttribute("user");
	List<String> list = (ArrayList<String>) request.getAttribute("list");
	List<User> listUser = (ArrayList<User>) request.getAttribute("listUser");
	Map<String, String> map = (HashMap<String, String>) request.getAttribute("map");
	Map<String, User> mapUser = (HashMap<String, User>) request.getAttribute("mapUser");
%>
<b><%=u.getAddr().getTown() %></b>
<b><%=u.getAddr().getCity() %></b>
<b><%=u.getAddr().getPro() %></b>

<h4>名人：</h4>
<%=list.get(2) %>

<h4>listUser</h4>
<%=listUser.get(0).getAddr().getPro() %>

<h4>map: cities</h4>
<%=map.get("a") %>

<h4>map, User</h4>
<%=mapUser.get("a1").getAddr().getCity() %>

<%--
	传统方式获取作用域数据 缺点：
		1. 导入包
		2. 需要强转
		3. 代码麻烦
	使用EL表达式获取作用域数据：
		作用：
			获取作用域对象中的数据。指：pageContext,request,session,application中的数据
		语法：
			${expr}
			表达式：
				request对象存的请求数据 (query) 
					${param.key} 返回值
					${paramValues.key} 返回数组
				通过setAttribute方法存储到作用域的数据：
				   普通字符串：
					${key} 返回key对应的val，当val是普通字符串时
				   对象：
					${keyObj} 返回key对应的对象，当val是对象
					${keyObj.attr} 当key对应的val是obj，则 .attr取出obj的属性
					${keyList[idx]} 当key对应的val是list
					${keyMap.k} 当val是map，用 .k 取出值
	
		作用域查找顺序：
			默认查找：
				pageContext --> request --> session --> application
				注意：
					每次查找都是从小到大进行查找，找到了则获取，不再继续。
					注意四者的life。比如第一次写入session后session会持续一个会话。
			指定查找：
				${pageScope.hello}
				${requestScope.hello}
				${sessionScope.hello}
				${applicationScope.hello}
		EL表达式的逻辑运算：
			${逻辑表达式} && || !
			${算术表达式} + - * / %
			${关系表达式} > < = == != 
			注意：
				+表示加法运算，不表示字符连接，字符串会强转为数值。
				EL进行字符连接会报错。
			特殊：
				三目运算
		
		EL的空值判断：
			${empty key}
			作用：判断key对应的val是否有数据
	
		EL获取请求头数据和 Cookie数据：
			请求头数据：
				${header} 返回所有的请求头数据
				${header["key"]} 返回指定key的请求头数据
				${headerValues["key"]} 返回数组
			获取Cookie数据
				${cookie} 返回存储了所有的cookie对象的map集合
				${cookie.key} cookie map key对应的val对象
				${cookie.key.name} cookie map key对应的val对象的键名
				${cookie.key.value} cookie map key对应的val对象的值
	
	
	
--%>
<!-- 使用EL获取作用域对象数据 -->
<h2>使用EL获取作用域对象数据 </h2>
<b>${param.uname }</b>
<b>${param.pwd }</b><br/>
<b>${paramValues.fav[0] }</b><br/>
<b>${str }</b><br/>

<b>${user.addr.town }</b>
<b>${user.addr.city }</b>
<b>${user.addr.pro }</b>

<h4>名人：</h4>
${list[2] }

<h4>listUser</h4>
${listUser[0].addr.pro }

<h4>map: cities，map的EL表达式使用 map.key ==> map.get("key")</h4>
${map.a }

<h4>map, User</h4>
${mapUser.a1.addr.city }

<!-- EL的作用域查找顺序 -->
<h4>EL的作用域查找顺序</h4>
<%
	session.setAttribute("hello", "hello session1");
	pageContext.setAttribute("hello", "hello pageContext1");
	application.setAttribute("hello", "hello app1");
	request.setAttribute("hello", "hello req1");
	// 注意四者的life，session是一次会话 浏览器开关，application是server开关
	
%>

${requestScope.hello } <br/>
${pageScope.hello } <br/>
${sessionScope.hello } <br/>
${applicationScope.hello } <br/>

<h4>EL表达式的逻辑运算</h4>
<%
	int a = 11; // EL表达式只能去作用域中的数据，因此传统定义的变量不行。
	int b = 12;
	int sex = 1;
	request.setAttribute("a", 11);
	request.setAttribute("b", 21);
	request.setAttribute("sex", 1);
%>
a: ${a }
b: ${b }
${a+b }
${1+2 }
${1+"2" } <!-- 此处是3，字符串会强转为数值类型 -->
${4==4 }
${4>2 }
${4<4 }
${sex==1 ? "男" : "女" }

<h4>EL的空值判断</h4>
${empty s } <br/>
${empty s1 } <br/> new User() 不是空，有默认的值
${empty s2 } <br/>
${empty s3 } <br/>


<h4>EL获取请求头数据和 Cookie数据</h4>
${header['user-agent'] } <br/>
${headerValues['accept-language'][0] }<br/>

ck name: ${cookie.JSESSIONID.name }
ck value: ${cookie.JSESSIONID.value }



<br/>
<br/>
<br/>
<br/>
<br/>













