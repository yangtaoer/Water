function change(a) { //ajax实现局部刷新
	var name = $(a).attr('id'); //获取id
	$('#table_body').empty();//清空
	$.ajax({
		"url":"change.do",
		"type":"get",
		"data":"name="+name, //返回表名后缀
		"dataType":"json",
		"success":function(data) {
			//检查购物车数据,获取所有名字,将存在于本页的数据背景更改
			var trs = $('#foodsbody').children(); //获取所有tr
			var names = []; //声明一个数组
			for(i=0;i<trs.length;i++) {		
					var tds = $(trs[i]).children().eq(0);//获取每个tr中第一个td
					var relname = $(tds).html();
					names.push(relname);//存放到数组					
			}
			var count = 0;			//计数器
			var cols = parseInt(data.length/3)+1; //行数
			for(i=0;i<cols;i++) {
				$('#table_body').append("<tr id='table_tr'></tr>");
				for(j=0;j<3;j++) {
					count++;
					if(count>data.length) {  //当菜品用完就return
						return;
					}
					var food = data[count-1]; //获取对象
					var td = $('<td id="body_td" onclick="fonclick(this)">'+		//新建一个td
								'<img id="body_td_img" src='+food.path+'>'+
								'<span id="body_td_name">'+food.name+' '+food.price+' 元/份</span>	'+										
								'</td>');
					$('#table_body').children().eq(i).append(td);  //添加td
					if($.inArray(food.name,names) !== -1) {  //判断元素是否存在于数组中,如果不存在就返回-1,存在就返回元素坐标
						//如果存在就改变背景
						$(td).css("background","url('images/tdbgn.png')");
					}
				}
			}
			
		}
	});			
		
}


function searchn(){
	$('#table_body').empty();//清空
	var sname = $('#search').val();
	var url = "search.do";
	$.getJSON(url,{sname:sname},function(data){   //要传输给服务器的数据,要以键值对的形式传输{key:value}
		//检查购物车数据,获取所有名字,将存在于本页的数据背景更改
		var trs = $('#foodsbody').children(); //获取所有tr
		var names = []; //声明一个数组
		for(i=0;i<trs.length;i++) {		
				var tds = $(trs[i]).children().eq(0);//获取每个tr中第一个td
				var relname = $(tds).html();
				names.push(relname);//存放到数组					
		}
		var count = 0;			//计数器
		var cols = parseInt(data.length/3)+1; //行数
		for(i=0;i<cols;i++) {
			$('#table_body').append("<tr id='table_tr'></tr>");
			for(j=0;j<3;j++) {
				count++;
				if(count>data.length) {  //当菜品用完需要使用空的隐藏td来占位
					var td = $('<td id="body_td_hidden" style="border: 0px;"></td>');//创建一个隐藏无内容的td
					$('#table_body').children().eq(i).append(td);  //添加td
					continue;
				}
				console.log("count:"+count);
				var food = data[count-1]; //获取对象
				var td = $('<td id="body_td" onclick="fonclick(this)">'+		//新建一个td
							'<img id="body_td_img" src='+food.path+'>'+
							'<span id="body_td_name">'+food.name+' '+food.price+' 元/份</span>	'+										
							'</td>');
				$('#table_body').children().eq(i).append(td);  //添加td
				
				if($.inArray(food.name,names) !== -1) {  //判断元素是否存在于数组中,如果不存在就返回-1,存在就返回元素坐标
					//如果存在就改变背景
					$(td).css("background","url('images/tdbgn.png')");
				}
			}
		}
	});
}









