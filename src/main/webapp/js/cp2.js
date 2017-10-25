$(document).ready(function(){
	document.getElementById("hd").className="old";
	document.getElementById("newValue").className="old";	
});
function hd(){
	document.getElementById("hd").className="old";
}

function yc(yc){
	$(yc).parent().parent().remove();
} 

function getDateTime(date) {
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    var hh = date.getHours();
    var mm = date.getMinutes();
    var ss = date.getSeconds();
    return year + "-" + month + "-" + day + " " + hh + ":" + mm + ":" + ss;
}
function ConvertJSONDateToJSDate(jsondate) {
    var date = new Date(parseInt(jsondate, 10));
    return date;
}

/*将搜索出的菜品添加到修改区域*/
function bt(bt){
	var len=$("#tb").children();
/**/
	$("#tb").append('<tr>'
			+'	<td >'+$(bt).parent().parent().children().eq(0).text()+'</td>'
			+'	<td>'+$(bt).parent().parent().children().eq(1).text()+'</td>'
			+'	<td class="price">'+$(bt).parent().parent().children().eq(3).text()+'</td>'
			+'	<td class="num">'+$(bt).parent().parent().children().eq(2).text()+'</td>'
			+'	<td>'+$(bt).parent().parent().children().eq(4).text()+'</td>'
			+'	<td>'+$(bt).parent().parent().children().eq(5).text()+'</td>'
			+'	<td class="no">'+$(bt).parent().parent().children().eq(6).text()+'</td>'
			+'	<td>'+$(bt).parent().parent().children().eq(7).text()+'</td>'
			+'	<td><input type="button" value="移除" onclick="yc(this);"/></td>');
	$(bt).parent().parent().remove();
}

/*搜索选项*/
function find(){
	document.getElementById("hd").className="new";
	var pageCurrent=$("#pageId").data("pageCurrent");
	if(!pageCurrent)
		pageCurrent=1;
	var data={"abc":$("#info").val(),"pageCurrent":pageCurrent};
	$.getJSON("find.go",data,function(result){
		$("#hd_tb").empty();
		setHdTbRows(result.list);
		setPagination(result.pageObject)
	});
/*	$.ajax({
		"url":"sc.go",
		"type":"get",
		"dataType":"json",
		"data":{"abc":$("#info").val()},
		"success":function(data){
			$("#hd_tb").empty();
			setHdTbRows(data);
		}
	});*/
}
/*搜索出的菜品添加到hd*/
function setHdTbRows(data){
	for(var i=0;i<data.length;i++){
		var s=data[i];
		$("#hd_tb").append('<tr>'
			+'	<td>'+s.id+'</td>'
			+'	<td>'+s.yname+'</td>'
			+'	<td class="price">'+s.price+'</td>'
			+'	<td class="num">'+s.num+'</td>'
			+'	<td>'+s.update_time+'</td>'
			+'	<td>'+s.path+'</td>'
			+'	<td class="no">'+s.no+'</td>'
			+'	<td>'+s.search+'</td>'
			+'	<td><input type="button" value="+" onclick="bt(this);"/></td>');
	}
	
}
/*选择器事件  */
function fs(){
/* 	document.getElementById("newValue").value=""; */
	$("#newValue").val("");
	$("#newValue").next().text("");
/* 	var select=document.getElementById("select"); */
	var zl=$("#select").val();
	document.getElementById("selrelation").value=zl;
	document.getElementById("newValue").className="new";
	if(document.getElementById("selrelation").value==-1){
		document.getElementById("newValue").className="old";
	}
} 
/*修改按钮ajax实现*/
function xg(){
	/*	var zl=$("#select").val();
	var list=$('.'+zl)
	for(var i=0;i<list.length;i++ ){
		if(zl=="price"){
			list[i].innerHTML=list[i].innerHTML*$("#newValue").val();
		}
		if(zl=="num"){
			list[i].innerHTML=$("#newValue").val();
		}
	}*/
	/*获取class为id的集合 */
	var trs=$("#tb .no");
	var ss="";
	for(var i=0;i<trs.length;i++){
		var id=trs[i].innerHTML;
		ss=id+","+ss;
	}
 	$.ajax({
		"url":"xg.go",
		"type":"get",
		"cache":false,
		"dataType":"json",
		"data":{"xg_name":$("#select").val(),
				"xg_val":$("#newValue").val(),
				"xg_id":ss},
		"success":function(data){
 					$("#tb").text(""); 
 					for(var i=0;i<data.length;i++){
						var s=data[i];
						$("#tb").append('<tr>'
 								+'	<td>'+s.id+'</td>'
 								+'	<td>'+s.yname+'</td>'
 								+'	<td class="price">'+s.price+'</td>'
 								+'	<td class="num">'+s.num+'</td>'
 								+'	<td>'+s.update_time+'</td>'
 								+'	<td>'+s.path+'</td>'
 								+'	<td class="no">'+s.no+'</td>'
 								+'	<td>'+s.search+'</td>'
							+'	<td><input type="button" value="移除" onclick="yc(this);"/></td>');
					} 
				}
	}); 

}


