function back() {
	var url = "back.do";
	$.getJSON(url,function(result){
		console.log(result);
		if(result!=null)
			window.location.href="point.jsp";					
	});
}

function call() {
	alert("服务员正在招聘中~~~~(>_<)~~~~");
}