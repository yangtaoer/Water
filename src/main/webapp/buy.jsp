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

</head>
<body>
	<img alt="bg" src="images/dcxtbg.png" id="dcbg"/>
	<!-- logo区 -->
	<div id="logo">
		<img alt="logo" src="images/ydlogo.png" id="ydlogo">
		<span id="ydlogodh">					
			<a id="ydlogodhimg">回到首页</a> 	 <!-- 链接待写 -->
			<a id="ydlogodhimg">前往点餐</a>
			<a id="ydlogodhimg">注册会员</a>
			<a id="ydlogodhimg">关于我们</a>
		</span>
		<div id="zzsc"></div>
		<a id="logo_a" href="#">
			<img src="images/login.png">
			<span>登录</span>
		</a>
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
				<a id="ul_a" onclick="back();">返回点餐</a> 	 <!-- 链接待写 -->
				<a id="ul_a" href="pay.do">前往买单</a>
				<a id="ul_a" onclick="readJson();">呼叫服务</a>
			
			</div>	
		</div>
		
	
	</div>
	
</body>
</html>