function change(a) { //ajax实现局部刷新
	var name = $(a).attr('id'); //获取id
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
					$('#table_body').children().eq(i).append(	'<td id="body_td" onclick="fonclick(this)">'+
																'<img id="body_td_img" src='+food.path+'>'+
																'<span id="body_td_name">'+food.name+' '+food.price+' 元/份</span>	'+										
																'</td>');
				}
			}
			
		}
	});
	
	//检查购物车数据,将存在于本页的数据背景更改
	var trs = $('#foodsbody').children(); //获取所有tr
	var names = []; //声明一个数组
	for(i=0;i<trs.length;i++) {
		var num =$(trs[i]).children().length;//获取每个tr中td的个数
		for(j=0;j<num;j++) {
			var tds = $(trs[i]).children().eq(j);//获取每个td
			var arrname = tds.children().eq(1).html().split(" ",3);//获取名字价格字符串数组
			var relname = arrname[0]; //获取菜品名
			names.push(relname);//存放到数组
		}
	}
	
}