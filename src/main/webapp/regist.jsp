<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="dao.*" %>
<%@page import="web.*"%>
<!DOCTYPE html>
<html>
<head>
<title>注册VIP</title>
<link rel="stylesheet" href="css/maidan.css"/>
<!-- Javascript -->
<script src="js/onmouse.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/point-index.js"></script>
<script type="text/javascript" src="js/regist.js"></script>
<style type="text/css">
body {
	background-image:url(images/dcxtbg.png);
	background-size:100% 100%;
	width: 100%;
	height: 1199px;
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
</style>
</head>
<body>
<div id="all">
	<div id="logo"></div>
	<div class="s"><a href="sell.jsp">销量查询</a></div>
	<div class="s"><a href="cuisine.jsp">菜品查询</a></div>
	<div class="s"><a href="indent.jsp">订单查询</a></div>
	<div class="s"><a href="regist.jsp">注册会员</a></div>
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
    <img alt="bg" src="images/dcxtbg.png" id="dcbg"/>
	<div id="logo">	
	<img alt="logo" src="images/ydlogo.png" id="ydlogo">	
		<span id="ydlogodh">					
			<a id="ydlogodhimg" onclick="goHead();">回到首页</a> 	 <!-- 链接待写
			<a id="ydlogodhimg" onclick="goPoint();">前往点餐</a>
			<a id="ydlogodhimg" onclick="goVip();">注册会员</a>
			<a id="ydlogodhimg" onclick="goWe();">关于我们</a>
		</span>
		<div id="zzsc"></div>
		<a id="logo_a" href="login.jsp">
			<img src="images/login.png">
			<span id="userName">登录</span>
		</a>
		<a id="exit" onclick="exit()"></a>
	</div>
	 -->	
      <div id="main">
        <div id="d1">
          <div id="d2">
     <form method="post">
				<table>
					<tr>
						<td><input type="text" placeholder="10位以下数字" id="user" onblur="checkId();" value=""/></td>
					</tr>
					<tr>
						<td><input type="password" id="pwd" placeholder="密码(6位数字)" /></td>
					</tr>
					<tr>
						<td><input type="text" id="name" placeholder="用户名" /></td>
					</tr>
					<tr>
						<td><input type="text" id="money" placeholder="充值金额" /></td>
					</tr>
					<tr>
						<td><input id="sub" value="注&nbsp;&nbsp;&nbsp;册" 
						onmouseover="mouseover()" onmouseout="mouseout()" onclick="registUser();"/></td>
					</tr>					
				</table>
			</form>
        </div>
             
        </div>
      </div>
</body>
</html>
    