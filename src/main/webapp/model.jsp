<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>		
<html>
<head>
<title></title>
<script src="js/jquery-1.11.1.js" type="text/javascript"></script>
<meta charset="utf-8"/>
<script type="text/javascript">


	function f1(qx){
		var list=document.getElementsByName("ck");
		for(var i=0;i<list.length;i++){
			list[i].checked=qx.checked;
		}
	}
	
	function edAll(){
		document.getElementById("oper").value="xiugai";
		document.forms[0].submit();
		
	}
/* 	function fs(){
		var select=document.getElementById("s1");
		var zl=select.value;
		console.log(zl);
		document.getElementById("select").value=zl;
		console.log(document.getElementById("select").value);
		document.forms[0].submit;
	} */
	
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
</style>
</head>
<body>
		<div id="d1">
			<div id="d2">
				<div id="d21">
					<p>预留空间</p>
				</div>
				<div id="d22">
					<form action="op" method="post">
					<table id="t0" >
						<thead id="thead" >
							<tr>
							<th>全选<input type="checkbox" class="ckall"  id="ckall" onclick="f1(this);"/></th>	
							<th>编号</th><th>名称</th><th>单价</th><th>单位</th><th>种类</th><th>操作</th>
							</tr>
						</thead>
						<tbody id="tb" style="height:280px; ">
							<c:forEach items="${ls}" var="food" varStatus="s"> 
								<tr class="row${s.index%2+1}">
									<td><input type="checkbox"   name="ck" id="ck" value="${food.id}"/></td>
									<td>${food.id}</td>
									<td>${food.name}</td>
									<td>${food.price}</td>
									<td>${food.danwei}</td>
									<td>${food.zhonglei}</td>
									<td>
										<a href="op?oper=del&id=${food.id}">删除</a>&nbsp;
										<a href="op?oper=update&id=${food.id}">修改</a>
									</td>
								</tr>
							</c:forEach>	
						</tbody>
					</table>
					<p class="p1">
						<input type="hidden" value="pishan" name="oper" id="oper"/>
						
						<input type="submit" value="批量删除" />
						
						<input type="button" value="批量修改" onclick="edAll();"/>
						<!-- 种类选择 -->
						<select onchange="fs();" id="s1">
							<option value="-1">请选择种类</option>
							<c:forEach items="${zls}" var="zl" varStatus="s"> 
								<option>${zl}</option>
							</c:forEach>	
						</select>
						<input type="hidden" value="-1" name="select" id="select"/>
					</p>
					</form>
				</div>
				<div id="d23" >
					
					<p class="p2">
							<a href="op?page=1" name="sy" >首页</a> 
							<a href="op?page=${page-1<1?1:page-1} "  name="上一页" >上一页</a> 
							<a href="op?page=${page+1>lastpage?lastpage:page+1}"  name="下一页" >下一页</a> 
							<a href="op?page=${lastpage} " name="wy ">尾页</a>
					</p>
				</div>
			</div>
		</div>
</body>
</html>