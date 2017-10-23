<%@ page pageEncoding="utf-8" 
contentType="text/html; charset=utf-8" %>
<html>
<head>
<title>买单</title>
<link rel="stylesheet" href="css/maidan.css"/>
<!-- Javascript -->
<script src="js/onmouse.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/zzsc.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/maidan-readvip.js"></script>
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
      
      <div id="main">
        <div id="d1">
          <div id="d2">
          <p id="pspan">您本次消费金额为：<span id="zongjine"></span></p>
     <form method="post">
				<table>
					<tr>
						<td><input type="text" placeholder="会员卡卡号" id="user"  style="color:#707070;"/></td>
					</tr>
					<tr>
						<td><input type="password" placeholder="密码（6位数字）"  id="pwd"  style="color:#707070;"/></td>
					</tr>
					<tr>
						<td><input id="sub"  value="会&nbsp;&nbsp;员&nbsp;&nbsp;买&nbsp;&nbsp;单" 
						onmouseover="mouseover()" onmouseout="mouseout()" onclick="gobuy();"/>
						</td>
					</tr>	
					<tr>
						<td><input id="sub2" value="普&nbsp;&nbsp;通&nbsp;&nbsp;买&nbsp;&nbsp;单" 
						onmouseover="mouseover2()" onmouseout="mouseout2()" onclick="gobuy2();"/>
						</td>
					</tr>				
				</table>
			</form>
        </div>           
        </div>
      </div>
</body>
</html>
