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
/* 	$(function(){
		document.getElementById("newValue").className="old";
	}); */
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
		 text-align: center;
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
	span{
		
		display:block;
		float: left;
		border:1px solid red;
	}
	form p{
		position:relative;
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
						<p >
						<span style="width:50px; height:50px;"></span>
						<span style="width:160px; height:50px;">编号</span>
						<span style="width:160px; height:50px;">名称</span>
						<span style="width:160px; height:50px;">单位</span>
						<span style="width:160px; height:50px;">单价</span>
						<span style="width:160px; height:50px;">种类</span></p>
					<form action="op" method="post">
						<c:forEach items="${xlist}" var="food" varStatus="s"> 
							<input type="text" value="${food.id}" readonly="readonly" name="id" style="width:160px; height:45px;"/>
							<input type="text" value="${food.name}" name="name"  style="width:160px; height:45px;"/>
							<input type="text" value="${food.price}" name="price" style="width:160px; height:45px;"/>
							<input type="text" value="${food.danwei}" name="danwei" style="width:160px; height:45px;"/>
							<input type="text" value="${food.zhonglei}" name="zhonglei" style="width:160px; height:45px;"/><br>
						</c:forEach>	
						<input type="submit" value="提交"/>
					</form>
				</div>
			</div>
		</div>
</body>
</html>