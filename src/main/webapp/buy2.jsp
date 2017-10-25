<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="dao.*" %>
<%@page import="web.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改页</title>
<link rel="stylesheet" href="css/buy2.css"/>
<style></style>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/cp2.js"></script>
<script type="text/javascript" src="js/page2.js"></script>

<link rel="stylesheet" type="text/css"  href="css/cpend2.css"/>
<style type="text/css">
body {
	background-image:url(images/dcxtbg.png);
	background-size:100% 100%;
	width: 100%;
	height: 970px;
	margin: 0 auto;
}
#all {
	width: 100%;
	background-image:url(images/logo_bg.png);
	height: 150px;	
}
#logo {
	float: left;
	/*border: 1px solid red;*/
	background-image:url(images/ydlogo.png);
	background-size:100% 100%;
	font-size: 32px;
	color: #fff;
	width: 300px;
	height: 150px;
	line-height: 100px;
	text-align: center;
	position: relative ;
	left:300px;
}
.s {
	float: left;
	width:140px;
	height:61px;
	background-image:url(images/logodh.png);
	margin-top:80px;
	margin-left:4%;
	border-radius: 12px;
	text-align: center; /* 文字水平居中 */
	line-height: 60px; /* 行高 */
	position: relative ;
	left:300px;
}
.s>a {
	color: #fff;
	text-decoration: none; /* 文字下划线 */
}
.user {
	float: right;
	right:50px;
	width: 380px;
	height: 150px;
	color: #fff;
	text-align: center; /* 文字水平居中 */
	line-height: 80px; /* 行高 */
}
#userimg {
	border:1px solid #d5d1ce;
	width:50px;
	height:50px;
	background:url(images/user.png) no-repeat;
	background-size:50px 50px;
	position: absolute;
	top:90px;
	right:300px;
}
.user>a{
	color: #fff;
	text-decoration: none; /* 文字下划线 */
}
tr{
height: 49px;
}
</style>
</head>
<body>
<div id="all">
	<div id="logo"></div>
	<div  class="s"><a href="sell.jsp">销量查询</a></div>
	<div  class="s"><a href="cuisine.jsp">菜品查询</a></div>
	<div  class="s"><a href="indent.jsp">订单查询</a></div>
	<div  class="s"><a href="regist.jsp">注册会员</a></div>
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
	<!-- 
	
	<div id="logo">
		
		<span id="ydlogodh">					
			<a id="ydlogodhimg">销量查询</a>
			<a id="ydlogodhimg">菜品查询</a>
			<a id="ydlogodhimg">订单查询</a>
			<a id="ydlogodhimg">注册会员</a>
		</span>
		<div id="zzsc"></div>
		<a id="logo_a" href="#">
			<img src="images/login.png">
			<span>登陆</span>
		</a>
	</div>	
	 -->
	 
	<div id="mid">
		<div id="content">
			<div id="t_head"></div>
			<div id="t_head1"></div>
			<div id="t_head2"></div>
			<form>
				<div id="search">
					<input type="text" name="info" class="fm" id="info"/>
					<input type="button" value="搜索" id="sc" onclick="find();" />
				</div>
				<div id="data">
					<table id="t1">
						<thead>
							<tr>
								<th>id</th>
								<th>yname</th>
								<th>price</th>
								<th>num</th>
								<th>uptime</th>
								
								<th>path</th>
								<th>no</th>
								<th>search</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="tb">
							<c:forEach items="${ls}"  var="cp">
								<tr>
									<td>${cp.id}</td>
									<td>${cp.yname}</td>
									<td class="price">${cp.price}</td>
									<td class="num">${cp.num}</td>
									<td>${cp.update_time}</td>
									<td>${cp.path}</td>
									<td class="no">${cp.no}</td>
									<td>${cp.search}</td>
									<td><input type="button" value="移除" onclick="yc(this);"/></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div id="hd">
						<table>
							<thead>
								<tr>
									<th>id</th>
									<th>yname</th>
									<th>price</th>
									<th>num</th>
									<th>uptime</th>
									
									<th>path</th>
									<th>no</th>
									<th>search</th>
									<th>操作</th>
								</tr>
								</thead>
							<tbody id="hd_tb">

							</tbody>
						</table>
						<%@include file="../common/page.jsp"%>
					</div>
				</div>
				<div id="mune">
					<span>条件</span>
					<select onchange="fs();" id="select">
						<option value="-1">请选择</option>
						<option value="price">折扣</option>
						<option value="num">库存</option>
<!-- 						<option value="zl">种类</option> -->
					</select>
					<input type="hidden" value="-1" name="selrelation" id="selrelation"/>
						<input type="text" value="在这里输入" name="newValue" id="newValue" /><span></span>
<!-- 					<input type="text" name="discount" id="fs_xy"/> -->
					<input type="button" value="修改" onclick="xg();"/>
<!-- 					<input type="submit" value="提交"/> -->
					<input type="button" value="返回" onclick="window.history.back(-1);"/>
				</div>
			</form>
		</div>
	</div>
	
	
</body>
</html>