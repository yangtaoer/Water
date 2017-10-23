function checkId(){
	var id = $("#user").val();
	if(id.length>10 || !checkNumber(id)){
		alert("请输入正确的数字!");
		return;
	}
	var url = "registcheck.do";
	$.getJSON(url,{"id":id},function(data){
		if(data=="no"){
			$("#user").css("border","1px solid red");
			$("#user").css("color","red");
			$("#user").val("该用户已存在!");
		}
		if(data=="yes"){
			$("#user").css("border","1px solid green");
			$("#user").css("color","green");
		}
	});
}

function registUser() {
	var id = $("#user").val();
	var name = $("#name").val();
	console.log("name---"+name);
	var pwd = $("#pwd").val();
	var money = $("#money").val();
	var params = {"id":id,"name":name,"pwd":pwd,"money":money};
	console.log(params);
	var url = "registUser.do";
	$.getJSON(url,params,function(data){
		if(data=="yes"){
			alert("注册成功!");
		}else{
			alert("注册失败!");
		}
	});
}

function checkNumber(theObj) {  
    var reg = /^[0-9]+.?[0-9]*$/;  
    if (reg.test(theObj)) {  
        return true;  
    }  
    return false;  
}  