/*$(document).ready(function(){
	$("#foot_buy").on("click",doPostData());
	console.log("ready");
});*/

function doPostData() {
	var jsons = [];
	var trs = $("#foodsbody").children();
	console.log(111);
	for(var i=0;i<trs.length;i++) {
		
		var tds = $(trs[i]).children();
		var name = $(tds[0]).html();
		var price = parseInt($(tds[1]).html(), 0);
		var prices = parseInt($(tds[3]).html(), 0);
		var data = {"name":name,"price":price,"prices":prices};
		console.log(data);
		jsons.push(data);
	}
	var jsonArr = $.toJSON(jsons);
	var url = "buy.do";
	$.post(url,{"json":jsonArr});
}

