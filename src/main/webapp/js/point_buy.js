function doPostData() {//订单提交时发生,将数据发送到后台加工并且保存到session
	var jsons = [];
	var trs = $("#foodsbody").children();
	if(trs.length==0){
		alert("您还没有选择任何东西!");
		return;
	}
	for(var i=0;i<trs.length;i++) {
		
		var tds = $(trs[i]).children();
		var name = $(tds[0]).html();
		var price = parseInt($(tds[1]).html(), 0);
		var prices = parseInt($(tds[3]).html(), 0);
		var no = $(trs[i]).data("no");
		var path = $(trs[i]).data("path");
		var data = {"name":name,"price":price,"prices":prices,"no":no,"path":path};
		jsons.push(data);
	}
	var jsonArr = JSON.stringify(jsons);/*将json数组转换为json*/
	var url = "buy.do";
	$.getJSON(url,{"json":jsonArr},function(result){
		if(result!=null)
			window.location.href="buy.jsp";					
	});
}


