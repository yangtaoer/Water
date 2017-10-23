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
	var deskId = $("#userName").html();
	if(deskId=="登录"){
		alert("请先登录!");
		return;
	}
	if(checkvip()==0){
		alert("支付失败!");
		return;
	}
	if(checkpwd()==0){
		alert("支付失败!");
		return;
	}
	if(checkmoney()==0){
		alert("支付失败!");
		return;
	}
	//buysuccess();
	
}


function checkvip(){
	var f=1;
	var username= $('#user').val();
	console.log(username);
	if(username==null|username==""){
		alert("请输入卡号");
		f=0;
		}
	var url = "checkvip.do";
	var params = {"user":username};
	console.log("checkvip:"+params);
	$.getJSON(url,params,function(data){
		if(data=="卡号不存在!") {
			alert(data);
			f=0;
		}			
	});
	console.log("vipfffffffff:"+f);
	return f;
}

function checkpwd(){
	 var f=1;
	 var password= $('#pwd').val();
	 console.log(password);
	 if(password==null|password==""){
			alert("请输入密码");
			f=0;
			}
		var url = "checkpwd.do";
		var params = {"pwd":password};
		$.post(url,params,function(data){
			if(data=="密码错误!") {
				alert(data);
				f=0;
			}
		});
		console.log("pwdfffffffff:"+f);
		return f;
}


function checkmoney(){
		var f = 1;
		var money= $('#zongjine').html();
		var deskId = $("#userName").html();
		var card= $('#user').val();
	 	var url = "checkmoney.do";
		var params = {"money":money,"deskId":deskId,"card":card};
		$.getJSON(url,params,function(data){
			if(data.indexOf("余额")<0) {
				alert("存在");
				alert(data);
				f=0;
			}
			alert(data);
			buysuccess();
		});
		console.log("moneyfffffffff:"+f);
		return f;
}
function gobuy2(){
	alert("支付成功!");
	buysuccess();
}
function buysuccess(){	
	window.location.replace("http://www.baidu.com");
}











