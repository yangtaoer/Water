<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>		
<html>
<head>
<title>修改页面</title>
<script src="js/jquery-1.11.1.js" type="text/javascript"></script>
<meta charset="utf-8"/>
<script type="text/javascript">

/*全选功能  */
	function f1(qx){
		var list=document.getElementsByName("ck");
		for(var i=0;i<list.length;i++){
			list[i].checked=qx.checked;
		}
	}
	
/*选择器事件  */
	function fs(){
		document.getElementById("newValue").value="";
		$("#newValue").next().text("");
		var select=document.getElementById("select");
		var zl=select.value;
		console.log(zl);
		document.getElementById("selrelation").value=zl;
		console.log(document.getElementById("select").value);
		document.getElementById("newValue").className="new";
		if(document.getElementById("selrelation").value==-1){
			document.getElementById("newValue").className="old";
		}
	} 
/*修改提交  */	
 	function change(){
		if($("#selrelation").val()=="price"&!isNaN($("#newValue").val())){
			console.log("修改单价");
			if($(":checkbox:checked").length<1){
 	 			console.log("没有选择要修改的菜品")
 	 			return false;
 	 		}
			return true;
		}else if($("#selrelation").val()!="price"&isNaN($("#newValue").val())){
			console.log("修改qita ");
			if($(":checkbox:checked").length<1){
 	 			console.log("没有选择要修改的菜品")
 	 			return false;
 	 		}
			return true;
		}
	}
	
 	function yz(){
 		var select=$("#selrelation").val();
 		var reg=/^\d{1,5}\.\d{1,2}$/;
 		var reg2 = /\s+/g;
 		if(select=="price"){/*修改单价判断  */
 			if(!reg.exec($("#newValue").val())){
 	 			$("#newValue").next().text("请输入正确的数字");
 	 			return false;
 	 		}else{
 	 			$("#newValue").next().text("格式正确");
 	 			return true;
 	 		}
 		}else{/*修改单位 种类 简单判断非空  */
 			if(reg2.test($("#newValue").val())|$("#newValue").val().length<1){
 				$("#newValue").next().text("不能为空或者含有空字符");
 				return false;
 			}
 			$("#newValue").next().text("待定");
 			return true;
 		}
 		
 	
 		
 	}

 	
/*隐藏输入框  */
	$(function(){
		document.getElementById("newValue").className="old";
	});
</script>
<style type="text/css">
	#d1{
		width:100%;
		height:500px;
		border:1px solid blue;
		margin-top: 50px;
	}
	#d2{
		width:900px;
		height:480;
		border:2px solid red;
		margin:5px auto;
	}
	#d2 #d21{
		height:30px;
		text-align: center;
		font-size: 25px;
		color:red;
	}
	#d2 #d22{
		height:350px;
		border:1px solid red;
	}
	#d2 #d23{
		 height:95px; 
		 position: relative;
		 text-align: center;
	}
/* 	#d2 #d23 .p2{
		position:absolute;
		text-align: center;
		line-height: 30px;
		top:30px;
		left:40%;
		 */
	}
	#t0{
		width:95%;
		height:335px;
		margin:0px  auto;
		border-collapse: collapse;
	}

	 #thead th{
		height:50px;;
		width:120px;
		border:1px solid blue;
	}
	 #tb tr{
	 }
	 #tb tr td{
	 	text-align:center;
	 	height:30px;;
		width:120px;
		margin:10px auto;
		border:1px solid blue;
	}
	.row1{
		corlor:#eee;
	}
	.row1{
		corlor:#bbb;
	}
	.new{
		display: inline;
	}
	.old{
		display: none;
	}
	
	
</style>
</head>
<body>
		<div id="d1">
			<div id="d2">
				<div id="d21">
					<p>非专业人士，请勿乱动</p>
				</div>
				<div id="d22">
					<form action="op" method="post" onsubmit="return yz()+change()==2">
					<table id="t0" >
						<thead id="thead" >
							<tr>
							<th>全选<input type="checkbox" class="ckall"  id="ckall" onclick="f1(this);"/></th>	
							<th>编号</th><th>名称</th><th>单价</th><th>单位</th><th>种类</th>
							</tr>
						</thead>
						<tbody id="tb" style="height:280px; ">
							<c:forEach items="${xlist}" var="food" varStatus="s"> 
								<tr class="row${s.index%2+1}">
									<td><input type="checkbox"   name="ck" id="ck" value="${food.id}"/></td>
									<td>${food.id}</td>
									<td>${food.name}</td>
									<td>${food.price}</td>
									<td>${food.danwei}</td>
									<td>${food.zhonglei}</td>
								</tr>
							</c:forEach>	
						</tbody>
					</table>
					<p class="p1">
						<input type="hidden" value="xiugai2" name="oper" id="oper"/>
						
						<!-- 种类选择 -->
						<select onchange="fs();" id="select">
							<!-- <option value="-1">请单价种类</option> -->
								<option value="price">单价</option>
								<!-- <option value="danwei">单位</option>
								<option value="zhonglei">种类</option> -->
						</select>
						<input type="hidden" value="-1" name="selrelation" id="selrelation"/>
						<input type="text" value="在这里输入" name="newValue" id="newValue" onblur="yz();"/><span></span>
						<input type="submit" value="确认" onclick="change();"/>
					</p>
					</form>
				</div>
			</div>
		</div>
</body>
</html>