<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>登录</title>
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" type="text/css" href="css/background.css">
<!-- Javascript -->
<script src="js/canvas_clock.js"></script>
<script src="js/onmouse.js"></script>
<script src="js/jquery-1.11.1.js"></script>
<script src="js/login.js"></script>
</head>
<body>
	<div class="slideshow">
		<div class="slideshow-image" style="background-image: url('images/5.jpg')"></div>
		<div class="slideshow-image" style="background-image: url('images/6.jpg')"></div>
		<div class="slideshow-image" style="background-image: url('images/7.jpg')"></div>
		<div class="slideshow-image" style="background-image: url('images/8.jpg')"></div>
	</div>
	<div id="time">
		<canvas id="clock1_" width="200px" height="200px">
		</canvas>
	</div>
		<div id="login">
			<img src="images/ydlogo.png"/>
			<form action=""  method="post">
				<table>
					<tr>
						<td><input id="username" type="text" placeholder="账号" name="username"/></td>
					</tr>
					<tr>
						<td><input id="password" type="password" placeholder="密码" name="password"/></td>
					</tr>
					<tr>
						<td><input id="sub" type="button" value="登&nbsp;&nbsp;&nbsp;录" 
						onmouseover="mouseover()" onmouseout="mouseout()"/></td>
					</tr>					
				</table>
			</form>
			<p id="p2">Copyright 2017 jsd1706_3 group. All Rights Reserved</p>
		</div>
<script src="js/clockoptions.js"></script>
</body>
</html>