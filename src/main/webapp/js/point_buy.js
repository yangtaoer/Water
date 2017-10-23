function doPostData() {
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
		var data = {"name":name,"price":price,"prices":prices,"no":no};
		console.log(data);
		jsons.push(data);
	}
	var jsonArr = JSON.stringify(jsons);/*将json数组转换为json*/
	console.log(jsonArr);
	var url = "buy.do";
	$.getJSON(url,{"json":jsonArr},function(result){
		console.log(result);
		if(result!=null)
			window.location.href="buy.jsp";					
	});
}


