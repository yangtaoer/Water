$(document).ready(function(){
	console.log("readreadJson");
	readJson();
});
function readJson(){
	console.log("readJson");
	var url = "readJson.do";
	$.getJSON(url,function(data){ 
		
		var names = [];
		var name = $("#li_head").html();
		names.push(name);
		console.log(names);
		var money = 0;
		for(var i=0;i<data.length;i++){
			var f = data[i];
			console.log("f:"+f);
			var ul = parseInt((Math.floor(f.no/100)));
			if(ul!="1" & ul!="9") {
				ul = "2";
			}
			var li = $("<li>"+"         "+f.name+"         "+f.price+"         "+f.prices+"</li>");
			$("#"+ul).append(li);
			money += f.prices;
		}
		$("#sum").html(money);
	});
}