$(document).ready(function(){
	var url = "getLoginMsg.do";
	$.getJSON(url,function(data){
		if(data!=null) {
			var name = data+"号桌";
			$("#userName").html(name);
			$("#exit").html("退出");
			$("#logo_a").attr("href","#");
		} 
	});
	
});

function exit(){
	$("#userName").html("登录");
	$("#exit").html("");
	$("#logo_a").attr("href","login.jsp");
	var url = "exit.do";
	$.post(url);
}