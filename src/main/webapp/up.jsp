<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<html>
<head>
<title></title>
<meta charset="utf-8"/>
</head>
<body>
	<form action="op" method="post">
	<input type="hidden" name="oper" value="updt"/>
	id:<input type="text" value="${ff.id }" readonly name="id"/><br/>
	name:<input type="text" value="${ff.name }" name="name"/><br/>
	price:<input type="text" value="${ff.price }" name="price"/><br/>
	danwei:<input type="text" value="${ff.danwei }" name="danwei"/><br/>
	zhonglei:<input type="text" value="${ff.zhonglei }" name="zhonglei"/><br/>
	<input type="submit" value="确认"/>
	
	</form>
</body>
</html>