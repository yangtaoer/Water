function change(a) { //ajax实现局部刷新
	var name = $(a).attr('id');
	$('#table_body').empty();//清空
	$.ajax({
		"url":"change.do",
		"type":"get",
		"data":"name="+name, //返回表名后缀
		"dataType":"json",
		"success":function(data) {
			var count = 0;			//计数器
			var cols = parseInt(data.length/3)+1; //行数
			for(i=0;i<cols;i++) {
				$('#table_body').append("<tr></tr>");
				for(j=0;j<3;j++) {
					count++;
					if(count>data.length) {  //当菜品用完就return
						return;
					}
					var food = data[count-1]; //获取对象
					$('#table_body').children().eq(i).append('<td id="body_td" onclick="fonclick(this)">'+
												'<img src='+food.path+'>'+
												'<span id="body_td_name">'+food.name+' '+food.price+' 元/份</span>	'+										
												'</td>');
				}
			}
			
		}
	});
}