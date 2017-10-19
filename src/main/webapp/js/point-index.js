$(document).ready(function(){
	var url = "getLoginMsg.do";
	$.getJSON(url,function(data){
		if(data!=null) {
			var name = data+"号桌";
			console.log(name);
			$("#userName").html(name);
		} 
	});
	
});