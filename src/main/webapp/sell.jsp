<%@ page import="dao.*" %>
<%@page import="web.*"%>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>销量查询</title>
<link rel="stylesheet" type="text/css" href="css/style1.css" />
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/sell.js"></script>
<script type="text/javascript" src="js/page.js"></script>
</head>
<body>
	<div id="all">
	<div id="logo"></div>
	<div id="s1" class="s"><a href="sell.jsp">销量查询</a></div>
	<div id="s2" class="s"><a href="cuisine.jsp">菜品查询</a></div>
	<div id="s3" class="s"><a href="indent.jsp">订单查询</a></div>
	<div id="s4" class="s"><a href="regist.jsp">注册会员</a></div>
	<div class="user"><br>
		<div id="userimg"></div>
		你好，
		<%	
			//int id = (int)request.getAttribute("id");
			CuisineDao dao = new CuisineDao();
			String name = dao.findName(1);
			PageObject po = (PageObject)request.getAttribute("po");
		%>
		<input type='hidden' value="<%= po %>" id="po" >  
		<%=name %>
		&nbsp;&nbsp;<a href="login.jsp">退出</a>
	</div>
</div>
<div id="content">
	<div id="find">
		<div id="dc"><a href="javascript:;">今日菜品</a></div>
		<div id="dd"><a href="javascript:;">今日酒水</a></div>
		<div id="dp"><a href="javascript:;">今日锅底</a></div>
		<div id="wc"><a href="javascript:;">本周菜品</a></div>
		<div id="wd"><a href="javascript:;">本周酒水</a></div>
		<div id="wp"><a href="javascript:;">本周锅底</a></div>
		<div id="mc"><a href="javascript:;">本月菜品</a></div>
		<div id="md"><a href="javascript:;">本月酒水</a></div>
		<div id="mp"><a href="javascript:;">本月锅底</a></div>
	</div>
	<div class="table">
		<div id="t_head"></div>
		<div id="t_head1"></div>
		<div id="t_head2"></div>
		<div id="table_head">
			<div id="seek">
				<form>
					<input id="sname" name="sname" type="text" placeholder="请输入菜品名称"> <input id="ss" type="button" value="搜索">
				</form>	
			</div>
		</div>
		<table border="1" cellpadding="0" cellspacing="0">
			<thead>
				<tr><td>编号</td><td>名称</td><td>价格</td><td>销量</td><td>销售额</td></tr>
			</thead>
			<tbody id="tb"></tbody>
		</table>
		<div id="pageId">
			<a href="javascript:;" class="first">首页</a>&nbsp;
			<a href="javascript:;" class="pre">上一页</a>&nbsp;&nbsp;
			<a href="javascript:;" class="next">下一页</a>&nbsp;
			<a href="javascript:;" class="last">尾页</a>&nbsp;
			<a class="pageCount">总页数(1)</a>&nbsp;
			<a class="pageCurrent">当前页(1)</a>
		</div>
	</div>
</div>
</body>
</html>