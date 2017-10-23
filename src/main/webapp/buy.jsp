<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>开始点餐</title>
<link rel="stylesheet" href="css/buy.css"/>
<style></style>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/zzsc.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/buy_readjson.js"></script>
<script type="text/javascript" src="js/buy-back.js"></script>
<script type="text/javascript" src="js/point-index.js"></script>
<script type="text/javascript" src="js/point-go.js"></script>

</head>
<body>
	<img alt="bg" src="images/dcxtbg.png" id="dcbg"/>
	<!-- logo区 -->
	<div id="logo">	
	<img alt="logo" src="images/ydlogo.png" id="ydlogo">	
		<span id="ydlogodh">					
			<a id="ydlogodhimg" onclick="goHead();">回到首页</a> 	 <!-- 链接待写 -->
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
	<!-- 主体 -->
	<div id="main">
		<div id="main_mid">
			<div id="main_ul">
			<ul>
				<li id="li_head">已选锅底:    商品名--单价--数量--总价</li>
				<li id="li_body">
					<ul id="1">
						
					</ul>
				</li>
			</ul>
			
			<ul>	
				<li id="li_head">已选菜品:    商品名--单价--数量--总价</li>
				<li id="li_body">
					<ul id="2">
						
					</ul>
				</li>
			</ul>
			
			
			<ul>
				<li id="li_head">已选酒水:    商品名--单价--数量--总价</li>
				<li id="li_body">
					<ul id="9">
						
					</ul>
				</li>				
			</ul>
			<ul><li><h1>共计:<span id="sum"></span>元</h1></li></ul>
			</div>
			<div id="ul_btn">
				<a id="ul_a" href="point.jsp">返回点餐</a> 	 <!-- 链接待写 -->
				<a id="ul_a" href="maidan.jsp">前往买单</a>
				<a id="ul_a" onclick="call();">呼叫服务</a>
			
			</div>	
		</div>
		
	
	</div>
	
</body>
</html>