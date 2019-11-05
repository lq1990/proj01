
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>portal</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery.js" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">
	$(function(){
		var index=0;
		var imgLen = ${list.size()};
		$(".imgindex").eq(0).css("background","white"); // 设定初始
		
		$.each($(".adpic"),function(index, elemDom){
			$(elemDom).css("left", 300*index+"px");
		});
		
		setInterval(function(){
			$.each($(".adpic"),function(index, elemDom){
				// animate(属性值，完成动作持续秒, fn
				$(elemDom).animate({"left":parseInt($(elemDom).css("left"))-300+"px"}, 
						800, function(){
					// 当动画完成之后 执行的功能
					if(index==0) {
						var $newimg = $(elemDom).clone();
						$(elemDom).remove();
						$newimg.css("left","600px");						
						$("#addiv").append($newimg);
					}
				});
			});
			
			index++;
			if(index > imgLen-1){
				index=0;
			}
			
			$(".imgindex").css("background", "gray");
			$(".imgindex").eq(index).css("background","white");
		},3000);
		
	})
</script>

</head>

<body>
	<div id="addiv"
		style="width: 300px; height: 185px; border: 2px solid red; margin-left:100px; position: absolute;overflow:hidden;">
		
		<c:forEach items="${list }" var="pic">
			<img class="adpic" src="${pic.path }" width="300px" height="185"
				style="position: absolute;" />
		</c:forEach>
	</div>
	<div style="position:absolute;top:165px;left:240px;">
		<c:forEach begin="1" end="${list.size() }" var="step">
			<span class="imgindex" style="background-color:gray;">${step }</span>
		</c:forEach>
	</div>
	
</body>
</html>











