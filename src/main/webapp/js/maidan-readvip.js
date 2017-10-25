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
			checkpwd();
		}			
	});
	
}

function checkpwd(){
	 var password= $('#pwd').val();
	 if(password==null|password==""){
			alert("请输入密码");
			return;
			}
		var url = "checkpwd.do";
		var params = {"pwd":password};
		$.getJSON(url,params,function(data){//post和getjson区别
			if(data=="pwderror"){
				alert("密码错误!");
			}
			if(data=="pwdright"){		
				checkmoney();
			}
		});
}

function checkmoney(){
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
	window.location.href="index.jsp";
}
function buyfail(){	
	window.location.href="maidan.jsp";
}











