<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EPOS首页</title>
<link rel="stylesheet" href="css/index.css"/>
<style></style>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/zzsc.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/point-go.js"></script>
<script type="text/javascript" src="js/point-index.js"></script>


</head>
<body>
	
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
	<div class="slideshow">
		<div class="slideshow-image" style="background-image: url('images/index.jpg')"></div>
		<div class="slideshow-image" style="background-image: url('images/index1.jpg')"></div>
		<div class="slideshow-image" style="background-image: url('images/index2.jpg')"></div>
		<div class="slideshow-image" style="background-image: url('images/index3.jpg')"></div>
	</div>
	
</body>
</html>