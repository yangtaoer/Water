<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="emp.YdEmp,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
																			<!-- 美味锅底页面 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>开始点餐</title>
<link rel="stylesheet" href="css/main.css"/>
<style></style>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/zzsc.js"></script>
<script type="text/javascript" src="js/js-jmc.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
</head>
<body>
	<img alt="bg" src="images/dcxtbg.png" id="dcbg"/>
	<!-- logo区 -->
	<div id="logo">
		<img alt="logo" src="images/newydlogo.png" id="ydlogo">
		<span id="ydlogodh">
			<img alt="logo" src="images/logodh.png" id="ydlogodhimg">
			<img alt="logo" src="images/logodh.png" id="ydlogodhimg">
			<img alt="logo" src="images/logodh.png" id="ydlogodhimg">
			<img alt="logo" src="images/logodh.png" id="ydlogodhimg">
		</span>
		<div id="zzsc"></div>
	</div>	
	<!-- 主体 -->
	<div id="main">
		<div id="main_left">
			<div id="search_box">
				<input type="text" placeholder="搜索" id="search" />
				<button id="search_btn"></button>
			</div>
			<ul id="main_left_ul">			
				<li><a href="#">菜品排行类</a></li>
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
					<thead>
						<tr></tr>
					</thead>
					<tbody id="table_body">
								
					</tbody>
				</table>
							
			</div>
			<div id="main_mid_right">
				<!-- 购物车 -->
				<div id="gwcdh_div">
					<img id="gwcdh" src="images/gwc.png">	
				</div>	
				<div id="gwc_head">		
					<table id="table_head" >
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
				<div id="gwc_div">
					<table id="foods">
					<tbody id="foodsbody">
											
					</tbody>					
					</table>								
				</div>
				<div id="gwc_buy">
					<table id="foot">						
						<tr>
          					<td id="foot_all" align="right">总计(元):</td>
         	 				<td id="total">0.00</td>
          					<td id="ra">
          						<a href="#" onclick="removeAll();" id="foot_btn">清空购物车</a>
          					</td>
          					<td>
          						<a id="foot_buy" href="#">去买单!>></a>
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