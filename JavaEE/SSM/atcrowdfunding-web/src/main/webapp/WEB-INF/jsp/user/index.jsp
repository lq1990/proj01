<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

	<link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
	<link rel="stylesheet" href="${APP_PATH}/css/main.css">
	
	
	<style>
	.tree li {
        list-style-type: none;
		cursor:pointer;
	}
	table tbody tr:nth-child(odd){background:#F4F4F4;}
	table tbody td:nth-child(even){color:#C00;}
	</style>
  </head>

  <body>
	
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <div><a class="navbar-brand" style="font-size:32px;" href="#">众筹平台 - 用户维护</a></div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li style="padding-top:8px;">
				<div class="btn-group">
				  <button type="button" class="btn btn-default btn-success dropdown-toggle" data-toggle="dropdown">
					<i class="glyphicon glyphicon-user"></i> 张三 <span class="caret"></span>
				  </button>
					  <ul class="dropdown-menu" role="menu">
						<li><a href="#"><i class="glyphicon glyphicon-cog"></i> 个人设置</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
						<li class="divider"></li>
						<li><a href="index.html"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
					  </ul>
			    </div>
			</li>
            <li style="margin-left:10px;padding-top:8px;">
				<button type="button" class="btn btn-default btn-danger">
				  <span class="glyphicon glyphicon-question-sign"></span> 帮助
				</button>
			</li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
			<div class="tree">
				<%@include file="/WEB-INF/jsp/common/menu.jsp" %>			
			</div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="panel panel-default">
			  <div class="panel-heading">
				<h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
			  </div>
			  <div class="panel-body">
<form class="form-inline" role="form" style="float:left;">
  <div class="form-group has-feedback">
    <div class="input-group">
      <div class="input-group-addon">查询条件</div>
      <input id="queryText" class="form-control has-success" type="text" placeholder="请输入查询条件">
    </div>
  </div>
  
  <button id="queryBtn" type="button" class="btn btn-warning">
  	<i class="glyphicon glyphicon-search"></i> 查询</button>
  	
</form>
<button onclick="deleteUsers()" type="button" class="btn btn-danger" style="float:right;margin-left:10px;"><i class=" glyphicon glyphicon-remove"></i> 
	删除
</button>
<button type="button" class="btn btn-primary" style="float:right;" 
	onclick="window.location.href='${APP_PATH}/user/add'">
	<i class="glyphicon glyphicon-plus">
	</i> 
	新增
</button>
<br>
 <hr style="clear:both;">
          <div class="table-responsive">
            <form id="userForm">
            <table class="table  table-bordered">
              <thead>
                <tr >
                  <th width="30">#</th>
				  <th width="30"><input id="allSelBox" type="checkbox"></th>
                  <th>账号</th>
                  <th>名称</th>
                  <th>邮箱地址</th>
                  <th width="100">操作</th>
                </tr>
              </thead>
              
	              <tbody id="userData">
	              	<!-- 异步请求的数据，放到这里 -->
	              </tbody>
              
			  <tfoot>
			     <tr >
				     <td colspan="6" align="center">
						<ul class="pagination">
							<!-- 异步请求来的数据，放这里 -->
						
  					    </ul>
					 </td>
				 </tr>

			  </tfoot>
            </table>
            </form>
          </div>
			  </div>
			</div>
        </div>
      </div>
    </div>

    <script src="${APP_PATH }/jquery/jquery-2.1.1.min.js"></script>
    <script src="${APP_PATH }/bootstrap/js/bootstrap.min.js"></script>
	<script src="${APP_PATH }/script/docs.min.js"></script>
	<script src="${APP_PATH }/layer/layer.js"></script>
	
        <script type="text/javascript">
        	var likeflag = false;
        
            $(function () {
			    $(".list-group-item").click(function(){
				    if ( $(this).find("ul") ) {
						$(this).toggleClass("tree-closed");
						if ( $(this).hasClass("tree-closed") ) {
							$("ul", this).hide("fast");
						} else {
							$("ul", this).show("fast");
						}
					}
				});
			    
			    pageQuery(1);
			    
			    // 模糊查询点击按钮
			    $("#queryBtn").click(function(){
			    	var queryText = $("#queryText").val();
			    	if (queryText == "") {
						likeflag = false; // 当查询条件处不输入时，则不是模糊查询
					} else {
						likeflag = true;
					}
			    	
			    	pageQuery(1);
			    });
			    
			    
			    $("#allSelBox").click(function(){
			    	var flg = this.checked;

			    	// 将所有的选框和 最上面的一致
			    	$("#userData :checkbox").each(function(){
			    		this.checked=flg;
			    	});
			    });
			    
            });
            
            $("tbody .btn-success").click(function(){
                window.location.href = "assignRole.html";
            });
            $("tbody .btn-primary").click(function(){
                window.location.href = "edit.html";
            });
            
            // 异步分页查询
            function pageQuery(pageno) {
	            var loadingIndex = null;
	            var jsonData = {"pageno" : pageno, "pagesize": 5};
	            if (likeflag == true) {
					jsonData.queryText = $("#queryText").val();
				}
	            
            	// 异步请求
            	$.ajax({
            		type: "post",
            		url: "${APP_PATH}/user/pageQuery",
            		data: jsonData,
            		beforeSend: function () {
            			loadingIndex = layer.msg("处理中", {icon: 16});
            		},
            		success: function(result) {
            			// result是server响应的数据
            			
            			layer.close(loadingIndex);
            			
            			if (result.success) {
            				console.log("异步请求成功");
            				
							// 异步查询数据成功后，局部刷新页面
							var tableContent = "";
							var pageContent = "";
							
							
							var userPage = result.data;
							var users = userPage.datas;
							
							$.each(users, function(i, user){
								tableContent+= '<tr>';
				                tableContent+= '  <td>'+(i+1)+'</td>';
								tableContent+= '  <td><input type="checkbox" name="userid" value="'+user.id+'"></td>';
				                tableContent+= '  <td>'+user.loginacct +'</td>';
				                tableContent+= '  <td>'+user.username +'</td>';
				                tableContent+= '  <td>'+user.email+'</td>';
				                tableContent+= '  <td>';
								tableContent+= '      <button type="button" onclick="goAssignPage('+user.id+')" class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-check"></i></button>';
								tableContent+= '      <button onclick="goUpdatePage('+user.id+')" type="button" class="btn btn-primary btn-xs"><i class=" glyphicon glyphicon-pencil"></i></button>';
								tableContent+= '	  <button onclick="deleteUser('+user.id+', \''+user.loginacct+'\')" type="button" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button>';
								tableContent+= '  </td>';
				                tableContent+= '</tr>';
							});
							
							if (pageno > 1) {
								pageContent += '<li><a href="#" onclick="pageQuery('+(pageno-1) +')">上一页</a></li>';
							}
							
							for (var j = 1; j <= userPage.totalno; j++) {
								if (j == pageno) {
									pageContent += '<li  class="active"><a href="#">'+(j)+'</a></li>';
								}
								else {
									pageContent += '<li><a href="#" onclick="pageQuery('+(j)+')">'+(j)+'</a></li>';
								}
								
							}
							
							if (pageno < userPage.totalno) {
								pageContent += '<li><a href="#" onclick="pageQuery('+(pageno+1) +')">下一页</a></li>';
							}
							
							
							
							$("#userData").html(tableContent);
							$(".pagination").html(pageContent);
            				
						} else {
							layer.msg("用户信息分页查询失败", {time: 2000, icon:5, shift:5 }, function(){
								
							});
							
						}
            			
            		}
            	});
            	
            }
            
            function goAssignPage(id) {
            	window.location.href="${APP_PATH}/user/assign?id="+id;
            }
            
            function goUpdatePage(id) {
            	window.location.href="${APP_PATH}/user/edit?id="+id;
            }
            
            function deleteUser(id, loginacct) {
            	layer.confirm("删除用户信息【"+loginacct+"】，是否继续？", 
            			{icon:3, title:"提示"}, 
            			function(cindex){
            		// 确定 删除
            		$.ajax({
            			type:"post",
            			url:"${APP_PATH}/user/delete",
            			data: {
            				id: id
            			},
            			beforeSend: function(){
            				
            			},
            			success: function(result){
            				if (result.success) {
								pageQuery(1);
							} else {
								layer.msg("删除失败", {time:1000,icon:5,shift:5}, function(){
									
								});
							}
            			}
            		});
            		
            	}, function(){
            		// 取消
            	});
            	
            }
            
            function deleteUsers() {
            	var boxes = $("#userData :checkbox");
            	if (boxes.length==0) {
					layer.msg("请选择需要删除的用户项", {time:2000, icon:5, shift: 5}, function(){
						
					});
				} else {
					layer.confirm("删除选择的用户信息，是否继续？", 
	            			{icon:3, title:"提示"}, 
	            			function(cindex){
	            		
	            		// 确定 删除
	            		$.ajax({
	            			type:"post",
	            			url:"${APP_PATH}/user/deletes",
	            			data: $("#userForm").serialize(),
	            			beforeSend: function(){
	            				
	            			},
	            			success: function(result){
	            				if (result.success) {
									pageQuery(1);
								} else {
									layer.msg("删除失败", {time:1000,icon:5,shift:5}, function(){
										
									});
								}
	            			}
	            		});
	            		
	            	}, function(){
	            		// 取消
	            	});
				}
            }
            
        </script>
        
       
  </body>
</html>
