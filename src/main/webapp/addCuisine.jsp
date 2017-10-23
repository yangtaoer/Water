<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="web.*"%>
<%@page import="dao.*"%>
<!DOCTYPE html>
<html>
<head>
<title>添加菜品</title>
<link rel="stylesheet" type="text/css" href="css/style1.css" />
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/addcuisine.js"></script>
<style>
#all {
	position:fixed;
	top:0;
}
#add {
	border: 1px solid #808080;
	width: 350px;
	height:350px;
	text-align: center;
	padding: 30px;
	margin: 250px auto;
	background-color:#888888;
	opacity:0.4;
}
#add input {
	border-radius: 5px;
	font-size: 18px;
}
#qd {
	background-color: #008CBA;
	border: 2px solid #008CBA;
	width: 223px;
}
#qd:hover {
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
}
</style>
</head>
<body>
<div id="all">
	<div id="logo"></div>
	<div id="s1" class="s"><a href="sell.jsp">销量查询</a></div>
	<div id="s2" class="s"><a href="cuisine.jsp">菜品查询</a></div>
	<div id="s3" class="s"><a href="javascript:;">订单查询</a></div>
	<div id="s4" class="s"><a href="javascript:;">注册会员</a></div>
	<div class="user"><br>
		<div id="userimg"></div>
		&nbsp;&nbsp;&nbsp;你好，
		<%	
			//int id = (int)request.getAttribute("id");
			CuisineDao dao = new CuisineDao();
			String name = dao.findName(1);
			PageObject po = (PageObject)request.getAttribute("po");
		%>
		<input type='hidden' value="<%= po %>" id="po" >  
		<%=name %>
		&nbsp;&nbsp;<a href="">退出</a>
	</div>
	<div id="add">
		<form action="addCuisine.do" method="post">
			<input type="text" name="yname" placeholder="名字"><br>
			<br> <input type="text" name="price" placeholder="价格"><br>
			<br> <input type="text" name="num" placeholder="数量"><br>
			<br> <input type="text" name="path" placeholder="地址"><br>
			<br> <input type="text" name="no" placeholder="编号"><br>
			<br> <input type="text" name="search" placeholder="简写"><br>
			<br> <input id ="qd" type="submit" value="确定">
		</form>
	</div>
</div>
</body>
</html>