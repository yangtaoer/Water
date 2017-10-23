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
	checkvip();	
}


function checkvip(){
	var username= $('#user').val();
	if(username==null|username==""){
		alert("请输入卡号");
		return;
		}
	var url = "checkvip.do";
	var params = {"user":username};
	$.getJSON(url,params,function(data){
		if(data=="notfoundcard"){		
			alert("卡号不存在!");
		}
		if(data=="foundcard"){
			console.log("卡号正确");
			checkpwd();
		}			
	});
	
}

function checkpwd(){
	console.log("开始检查密码");
	 var password= $('#pwd').val();
	 if(password==null|password==""){
			alert("请输入密码");
			return;
			}
		var url = "checkpwd.do";
		var params = {"pwd":password};
		$.getJSON(url,params,function(data){//post和getjson区别
			console.log("检查密码回调函数:"+data);
			console.log(data==="pwderror");
			console.log(data==="pwdright");
			if(data=="pwderror"){
				console.log("密码错误");
				alert("密码错误!");
			}
			if(data=="pwdright"){
				console.log("密码正确");
				checkmoney();
			}
		});
}

function checkmoney(){
	console.log("开始检查余额");
		var money= $('#zongjine').html();
		var deskId = $("#userName").html();
		var card= $('#user').val();
	 	var url = "checkmoney.do";
		var params = {"money":money,"deskId":deskId,"card":card};
		$.getJSON(url,params,function(data){
			if(parseFloat(data)<parseFloat(money)) {
				alert("余额不足!当前余额:"+data);
				return;
			}else{
				console.log("支付成功!");
				alert(data);
				buysuccess();
			}
		});
}
function gobuy2(){
	alert("支付成功!");
	buysuccess();
}
function buysuccess(){	
	window.location.replace("http://www.baidu.com");
}











