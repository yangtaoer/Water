<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
																			<!-- 点餐页面 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>开始点餐</title>
<link rel="stylesheet" href="css/point.css"/>
<style></style>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/zzsc.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/js-jmc.js"></script>
<script type="text/javascript" src="js/point-ajax.js"></script>
<script type="text/javascript" src="js/point_buy.js"></script>
<script type="text/javascript" src="js/point-go.js"></script>
<script type="text/javascript" src="js/point-index.js"></script>
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
		<div id="main_left">
			<div id="search_box">
				<input type="text" placeholder="搜索" id="search"/>
				<a id="search_btn" href="#" onclick="searchn();"></a>
			</div>
			<ul id="main_left_ul">			
				<li><a id="yd_sell" href="#" onclick="rank()">菜品排行类</a></li>
				<li><a id="mwgd" href="#" onclick="change(this);">美味锅底类</a></li>
				<li><a id="shwz" href="#" onclick="change(this);">顺滑丸子类</a></li>			
				<li><a id="jdcp" href="#" onclick="change(this);">经典菜品类</a></li>
				<li><a id="jpny" href="#" onclick="change(this);">精品牛羊类</a></li>
				<li><a id="hxhy" href="#" onclick="change(this);">海鲜河鱼类</a></li>
				<li><a id="dmzp" href="#" onclick="change(this);">豆面制品类</a></li>
				<li><a id="ysjg" href="#" onclick="change(this);">野生菌菇类</a></li>
				<li><a id="xxsc" href="#" onclick="change(this);">新鲜蔬菜类</a></li>
				<li><a id="mjky" href="#" onclick="change(this);">美酒酷饮类</a></li>
			</ul>
		</div>     <!-- 导航区 -->
		<div id="main_mid">
			<div id="main_mid_left" >    <!-- 选菜区--> 	
				<table id="food_show">   <!-- 菜品展示区  -->
					<tbody id="table_body">
		
					</tbody>
				</table>
							
			</div>
			<div id="main_mid_right">
				<!-- 购物车 -->
				<div id="gwcdh_div">
					<span id="gwc_span">0</span>
					<img id="gwcdh" src="images/gwc.png">	
				</div>	
				<div id="gwc_head">		
					<table id="table_head" >		<!-- 购物车表头 -->
					<thead>
						<tr>
         	 				<th id="table_head_1">商品</th>
         					<th id="table_head_1">单价(元)</th>
          					<th id="table_head_1">数量</th>
          					<th id="table_head_1">金额(元)</th>
          					<th id="table_head_1">删除</th>
        				</tr>
					</thead>
					</table>
				<div id="gwc_div">			<!-- 购物车表体 -->
					<table id="foods">
					<tbody id="foodsbody">
										
					</tbody>					
					</table>								
				</div>
				<div id="gwc_buy">				
					<table id="foot">						<!-- 购物车表尾 -->			
						<tr>
          					<td id="foot_all" align="right">总计(元):</td>
         	 				<td id="total">0.00</td>
          					<td id="ra">
          						<a href="#" onclick="removeAll();" id="foot_btn">清空购物车</a>
          					</td>
          					<td>
          						<a id="foot_buy" onclick="doPostData();">提交订单</a>
          					</td>
       					</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>