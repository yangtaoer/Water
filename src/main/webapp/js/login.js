$(function(){
	$("#sub").click(function(){
		var name = $("#username").val();
		var pwd = $("#username").val();
		if(name==null || name==""){
			alert("请输入用户名!");
			return;
		}
		if(pwd==null || pwd==""){
			alert("请输入密码!");
			return;
		}
		url = "login.do";
		params = {"username":$("#username").val(),
				  "password":$("#password").val()};
		$.post(url,params,function(result){
			check(result);
		})
		
	});
	
	
})
function check(result){
	if(-1!=result.indexOf("没有")){
		alert("用户名或桌号不存在")
		return false;
	}
	if(1==result.indexOf("用户名密码错误")){
		alert("用户名密码错误")
		return false;
	}
	if(1==result.indexOf("桌号密码错误")){
		alert("桌号密码错误")
		return false;
	}
	else if(1==result.indexOf("桌号登陆成功")){
		window.location.href ="index.jsp";
	}else if(1==result.indexOf("用户登陆成功")){
		window.location.href ="sell.jsp";
	}
	
}