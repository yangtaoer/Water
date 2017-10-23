<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>注册VIP</title>
<link rel="stylesheet" href="css/maidan.css"/>
<!-- Javascript -->
<script src="js/onmouse.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/zzsc.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/point-index.js"></script>
<script type="text/javascript" src="js/regist.js"></script>
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
    