<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title></title>
<meta charset="utf-8"/>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/cp.js"></script>
<script type="text/javascript" src="js/page.js"></script>
<link rel="stylesheet" type="text/css"  href="css/cpend.css"/>
</head>
<body>
	<div id="mid">
		<div id="content">
			<form>
				<div id="search">
					<input type="text" name="info" class="fm" id="info"/>
					<input type="button" value="搜索" id="sc" onclick="find();" />
				</div>
				<div id="data">
					<table class="t1">
						<thead>
							<tr>
								<th>id</th>
								<th>yname</th>
								<th>price</th>
								<th>num</th>
								<th>uptime</th>
								
								<th>path</th>
								<th>no</th>
								<th>search</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="tb">
							<c:forEach items="${ls}"  var="cp">
								<tr>
									<td >${cp.id}</td>
									<td>${cp.yname}</td>
									<td class="price">${cp.price}</td>
									<td class="num">${cp.num}</td>
									<td>${cp.update_time}</td>
									<td>${cp.path}</td>
									<td class="no">${cp.no}</td>
									<td>${cp.search}</td>
									<td><input type="button" value="移除" onclick="yc(this);"/></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div id="hd">
						<table>
							<thead>
								<tr>
									<th>id</th>
									<th>yname</th>
									<th>price</th>
									<th>num</th>
									<th>uptime</th>
									
									<th>path</th>
									<th>no</th>
									<th>search</th>
									<th>操作</th>
								</tr>
								</thead>
							<tbody id="hd_tb">

							</tbody>
						</table>
						<%@include file="../common/page.jsp"%>
					</div>
				</div>
				<div id="mune">
					<span>条件</span>
					<select onchange="fs();" id="select">
						<option value="-1">请选择</option>
						<option value="price">折扣</option>
						<option value="num">库存</option>
<!-- 						<option value="zl">种类</option> -->
					</select>
					<input type="hidden" value="-1" name="selrelation" id="selrelation"/>
						<input type="text" value="在这里输入" name="newValue" id="newValue" /><span></span>
<!-- 					<input type="text" name="discount" id="fs_xy"/> -->
					<input type="button" value="修改" onclick="xg();"/>
<!-- 					<input type="submit" value="提交"/> -->
					<input type="button" value="返回"/>
				</div>
			</form>
		</div>
	</div>
</body>
</html>