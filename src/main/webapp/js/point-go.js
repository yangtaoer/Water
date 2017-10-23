//点餐页面跳转链接待写------
function goHead(){
	window.location.href="index.jsp";
}
function goPoint(){
	window.location.href="point.jsp";
}
function goVip(){
	if(confirm("请先登录管理员账号!")){
		window.location.href="login.jsp";
	}
}
function goWe(){
	window.location.replace("http://www.7k7k.com");
}