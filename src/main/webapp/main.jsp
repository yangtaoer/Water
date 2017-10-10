<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>开始点餐</title>
<link rel="stylesheet" href="css/main.css"/>
<style></style>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/zzsc.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
	<img alt="bg" src="images/dcxtbg.png" id="dcbg"/>
	<!-- logo区 -->
	<div id="logo">
		<img alt="logo" src="images/newydlogo.png" id="ydlogo" >
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
				<li><a href="mwgd.do">美味锅底类</a></li>
				<li><a href="shwz.do">顺滑丸子类</a></li>			
				<li><a href="jdcp.do">经典菜品类</a></li>
				<li><a href="jpny.do">精品牛羊类</a></li>
				<li><a href="hxhy.do">海鲜河鱼类</a></li>
				<li><a href="dmzp.do">豆面制品类</a></li>
				<li><a href="ysjg.do">野生菌菇类</a></li>
				<li><a href="xxsc.do">新鲜蔬菜类</a></li>
				<li><a href="mjky.do">美酒酷饮类</a></li>
			</ul>
		</div>     <!-- 导航区 -->
		<div id="main_mid">
			<div id="main_mid_left" >    <!-- 选菜区--> 	
				<table id="food_show">   <!-- 菜品展示区  -->
					<thead>
						<tr></tr>
					</thead>
					<tbody id="table_body">
						<tr>
							<td style="background-color: #abcdef" id="body_td"><img src="images/101.jpg"/><span>商品描述230*80</span></td>
							<td id="body_td"><img src="images/101.jpg"/><span>商品描述230*80</span></td>
							<td id="body_td"><img src="images/101.jpg"/><span>商品描述230*80</span></td>						
						</tr>
						<tr>
							<td><img src="images/101.jpg"/><span>商品描述230*80</span></td>
							<td><img src="images/101.jpg"/><span>商品描述230*80</span></td>
							<td><img src="images/101.jpg"/><span>商品描述230*80</span></td>						
						</tr>
											
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
         					<th id="table_head_2">单价(元)</th>
          					<th id="table_head_3">数量</th>
          					<th id="table_head_4">金额(元)</th>
          					<th id="table_head_5">删除</th>
        				</tr>
					</thead>
					</table>
				<div id="gwc_div">
					<table id="foods">
					<tbody>
						<tr id="foods_tr">
							<td id="food_name">精品肥牛</td>
							<td>25.0</td>
							<td id="addsub">
								<button id="sub"></button>
								<input  id="num"  type="number" readonly value="1" />
								<button id="add"></button>
							</td>
							<td>25.0</td>
							<td>
							<button id="delete">X</button>
							</td>
						</tr>
						<tr id="foods_tr">
							<td id="food_name">精品肥牛</td>
							<td>25.0</td>
							<td id="addsub">
								<button id="sub"></button>
								<input  id="num"  type="number" readonly value="1" />
								<button id="add"></button>
							</td>
							<td>25.0</td>
							<td>
							<button id="delete">X</button>
							</td>
						</tr>
						<tr id="foods_tr">
							<td id="food_name">精品肥牛</td>
							<td>25.0</td>
							<td id="addsub">
								<button id="sub"></button>
								<input  id="num"  type="number" readonly value="1" />
								<button id="add"></button>
							</td>
							<td>25.0</td>
							<td>
							<button id="delete">X</button>
							</td>
						</tr>
						<tr id="foods_tr">
							<td id="food_name">精品肥牛</td>
							<td>25.0</td>
							<td id="addsub">
								<button id="sub"></button>
								<input  id="num"  type="number" readonly value="1" />
								<button id="add"></button>
							</td>
							<td>25.0</td>
							<td>
							<button id="delete">X</button>
							</td>
						</tr>
						<tr id="foods_tr">
							<td id="food_name">精品肥牛</td>
							<td>25.0</td>
							<td id="addsub">
								<button id="sub"></button>
								<input  id="num"  type="number" readonly value="1" />
								<button id="add"></button>
							</td>
							<td>25.0</td>
							<td>
							<button id="delete">X</button>
							</td>
						</tr>
						<tr id="foods_tr">
							<td id="food_name">精品肥牛</td>
							<td>25.0</td>
							<td id="addsub">
								<button id="sub"></button>
								<input  id="num"  type="number" readonly value="1" />
								<button id="add"></button>
							</td>
							<td>25.0</td>
							<td>
							<button id="delete">X</button>
							</td>
						</tr>
						<tr id="foods_tr">
							<td id="food_name">精品肥牛</td>
							<td>25.0</td>
							<td id="addsub">
								<button id="sub"></button>
								<input  id="num"  type="number" readonly value="1" />
								<button id="add"></button>
							</td>
							<td>25.0</td>
							<td>
							<button id="delete">X</button>
							</td>
						</tr>
						<tr id="foods_tr">
							<td id="food_name">精品肥牛</td>
							<td>25.0</td>
							<td id="addsub">
								<button id="sub"></button>
								<input  id="num"  type="number" readonly value="1" />
								<button id="add"></button>
							</td>
							<td>25.0</td>
							<td>
							<button id="delete">X</button>
							</td>
						</tr>
						<tr id="foods_tr">
							<td id="food_name">精品肥牛</td>
							<td>25.0</td>
							<td id="addsub">
								<button id="sub"></button>
								<input  id="num"  type="number" readonly value="1" />
								<button id="add"></button>
							</td>
							<td>25.0</td>
							<td>
							<button id="delete">X</button>
							</td>
						</tr>
						<tr id="foods_tr">
							<td id="food_name">精品肥牛</td>
							<td>25.0</td>
							<td id="addsub">
								<button id="sub"></button>
								<input  id="num"  type="number" readonly value="1" />
								<button id="add"></button>
							</td>
							<td>25.0</td>
							<td>
							<button id="delete">X</button>
							</td>
						</tr>
						<tr id="foods_tr">
							<td id="food_name">精品肥牛</td>
							<td>25.0</td>
							<td id="addsub">
								<button id="sub"></button>
								<input  id="num"  type="number" readonly value="1" />
								<button id="add"></button>
							</td>
							<td>25.0</td>
							<td>
							<button id="delete">X</button>
							</td>
						</tr>
						<tr id="foods_tr">
							<td id="food_name">精品肥牛</td>
							<td>25.0</td>
							<td id="addsub">
								<button id="sub"></button>
								<input  id="num"  type="number" readonly value="1" />
								<button id="add"></button>
							</td>
							<td>25.0</td>
							<td>
							<button id="delete">X</button>
							</td>
						</tr>
						<tr id="foods_tr">
							<td id="food_name">精品肥牛</td>
							<td>25.0</td>
							<td id="addsub">
								<button id="sub"></button>
								<input  id="num"  type="number" readonly value="1" />
								<button id="add"></button>
							</td>
							<td>25.0</td>
							<td>
							<button id="delete">X</button>
							</td>
						</tr>
						<tr id="foods_tr">
							<td id="food_name">精品肥牛</td>
							<td>25.0</td>
							<td id="addsub">
								<button id="sub"></button>
								<input  id="num"  type="number" readonly value="1" />
								<button id="add"></button>
							</td>
							<td>25.0</td>
							<td>
							<button id="delete">X</button>
							</td>
						</tr>
						<tr id="foods_tr">
							<td id="food_name">精品肥牛</td>
							<td>25.0</td>
							<td id="addsub">
								<button id="sub"></button>
								<input  id="num"  type="number" readonly value="1" />
								<button id="add"></button>
							</td>
							<td>25.0</td>
							<td>
							<button id="delete">X</button>
							</td>
						</tr>
						<tr id="foods_tr">
							<td id="food_name">精品肥牛</td>
							<td>25.0</td>
							<td id="addsub">
								<button id="sub"></button>
								<input  id="num"  type="number" readonly value="1" />
								<button id="add"></button>
							</td>
							<td>25.0</td>
							<td>
							<button id="delete">X</button>
							</td>
						</tr>
						<tr id="foods_tr">
							<td id="food_name">精品肥牛</td>
							<td>25.0</td>
							<td id="addsub">
								<button id="sub"></button>
								<input  id="num"  type="number" readonly value="1" />
								<button id="add"></button>
							</td>
							<td>25.0</td>
							<td>
							<button id="delete">X</button>
							</td>
						</tr>
						<tr id="foods_tr">
							<td id="food_name">精品肥牛</td>
							<td>25.0</td>
							<td id="addsub">
								<button id="sub"></button>
								<input  id="num"  type="number" readonly value="1" />
								<button id="add"></button>
							</td>
							<td>25.0</td>
							<td>
							<button id="delete">X</button>
							</td>
						</tr>
						
					</tbody>
					
					</table>								
				</div>
				<div id="gwc_buy">
					<table id="foot">						
						<tr>
          					<td id="foot_all" align="right">总计(元):</td>
         	 				<td id="total">9999.99</td>
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