$(document).ready(function(){	
	var url = "getMoney.do";
	$.getJSON(url,function(data){
		if(data==null){
			alert("您还没有买任何东西!");
			return;
		}
		$("#zongjine").html(data+"元");
	})
});

function gobuy(){//买单验证
	
	if(checkvip()=="no"){
		return;
	}
	if(checkpwd()=="no"){
		return;
	}
	if(checkmoney()=="no"){
		return;
	}
	buysuccess();
	
}

function checkpwd(){
	 var password= $('#pwd').val();
	 console.log(password);
	 if(password==null|password==""){
			alert("请输入密码");
			return "no";
			}
		var url = "checkpwd.do";
		var params = {"pwd":password};
		$.getJSON(url,params,function(data){
			if(data=="密码错误!") {
				alert(data);
				return "no";
			}
		});
}


function checkvip(){
	var username= $('#user').val();
	console.log(username);
	if(username==null|username==""){
		alert("请输入卡号");
		return "no";
		}
	var url = "checkvip.do";
	var params = {"user":username};
	$.getJSON(url,params,function(data){
		if(data=="卡号不存在!") {
			alert(data);
			return "no";
		}
			
	});

}
function checkmoney(){
		var money= $('#zongjine').html();
	 	var url = "checkmoney.do";
		var params = {"money":money};
		$.getJSON(url,params,function(data){
			if(data=="余额不足!") {
				alert(data);
				return "no";
			}
		});
}

function buysuccess(){
	var deskId = $("#userName").html();
	if(deskId=="登录"){
		alert("请先登录!");
		return;
	}
	var money = $("#zongjine") .html();
	var url = "savemoney";
	window.location.replace("http://www.baidu.com");
}











