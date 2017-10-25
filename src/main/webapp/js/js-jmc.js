$(document).ready(function(){	//点餐页面加载执行数据的读取工作
	load();	
});

function load(){//页面加载执行,用于订单页面返回点餐页面
	var url = "load.do";
	$.getJSON(url,function(data){
		if(data=="first"){		
			return;
		}
		for(var i=0;i<data.length;i++){//恢复购物车
			var f = data[i];
			var num = (f.prices)/(f.price);
			var tr = $('<tr id="foods_tr">'+
					'<td id="food_name">'+f.name+'</td>'+
					' <td>'+f.price+'</td>'+
					'<td id="addsub">'+
						'<button id="sub" onclick = "jian(this)">-</button>'+
						'<input  id="num"  type="number" readonly value="'+num+'" />'+
						'<button id="add" onclick = "jia(this)">+</button>'+
					'</td>'+
					'<td>'+f.prices+'</td>'+
					'<td>'+
					'<button id="delete" onclick = "remove(this);">X</button>'+
					'</td>'+
					'</tr>');
			$(tr).data("no",f.no);//转移no
			$(tr).data("path",f.path);//转移path
			$("#foodsbody").append(tr);
			sumAll();
			readtr();
		}
	});
	//$("#mwgd").trigger("click");//模拟点击事件
}
/*读取购物车商品数量,显示在购物车导航上*/
function readtr(){
	var trs = $("#foodsbody").children();
	var count=0;
	for(var i=0;i<trs.length;i++){
		var num = $(trs[i]).children().eq(2).children().eq(1).val();
		count += parseInt(num, 0);
	}
	$("#gwc_span").html(count);
}
/**
 * 自动生成购物车
 */
	function fonclick(btn){
		$(btn).css("background","url('images/tdbgn.png')");
		//获取图片的父倍
		var tds = $(btn).children();	
		//获取商品的名字和价格
		var name = tds[1];	
		//获取商品的单价
		var arr = name.innerHTML.split(" ",3);
		var price = parseInt(arr[1]);
		var foodname = arr[0];
		var trs = $("#foodsbody").children();//获取购物车中tr
		for(var i=0;i<trs.length;i++){
			var tds = trs.eq(i).children();
			var name = trs.eq(i).children().eq(0).html();
			if(foodname==name){				//名字相同就直接数量加一。
				jia(trs.eq(i).children().eq(2).children().eq(2));
				return;
			}
		}	
		//自动生成菜单表
		var new_trs = 
			$('<tr id="foods_tr">'+
					'<td id="food_name">'+arr[0]+'</td>'+
					' <td>'+price+'</td>'+
					'<td id="addsub">'+
						'<button id="sub" onclick = "jian(this)">-</button>'+
						'<input  id="num"  type="number" readonly value="1" />'+
						'<button id="add" onclick = "jia(this)">+</button>'+
					'</td>'+
					'<td>'+price+'</td>'+
					'<td>'+
					'<button id="delete" onclick = "remove(this);">X</button>'+
					'</td>'+
			'</tr>');
		$(new_trs).data("no",$(btn).data("no"));//转移no
		$(new_trs).data("path",$(btn).data("path"));//转移path
		$("#foodsbody").append(new_trs);
		sumAll();
		readtr();
	}
	
	
	/* 商品的减法 */
	function jian(btn) {
		//获取数量
		var n = $(btn).next().val();
		if(n == 1){
			alert("没办法再少了");
			return;
		}
		//数量减一，在写会文本框
		$(btn).next().val(--n);
		//获取单价
		var price = $(btn).parent().prev().html();
		//计算金额
		$(btn).parent().next().html(n*price);
		sumAll();
		readtr();
	}
	/* 商品的加法 */
	function jia(btn) {
		//获取数量
		var u = $(btn).prev().val();
		//数量加一，在写会文本框
		$(btn).prev().val(++u);
		//获取单价
		var price = $(btn).parent().prev().html();
		//计算金额
		$(btn).parent().next().html(u*price);
		sumAll();
		readtr();
	}
	/*删除一行*/
	function remove(btn) {
		if(!confirm("是否确认删除?")) {
			return;
		}
		//修改背景颜色
		
		var name = $(btn).parent().parent().children().eq(0).html();//获取菜品名称
		var trs = $('#table_body').children();
		for(i=0;i<trs.length;i++) {
			var num =$(trs[i]).children().length;//获取每个tr中td的个数
			for(j=0;j<num;j++) {
				var tds = $(trs[i]).children().eq(j);//获取每个td
				var arrname = tds.children().eq(1).html().split(" ",3);//获取名字价格字符串数组
				var relname = arrname[0]; //获取菜品名
				if(name == relname) {
					$(tds).css("background","");//改变背景颜色
				}
			}
		}
		$(btn).parent().parent().remove();
		sumAll();
		readtr();
	}
	//计算总价格
	function sumAll() {
		  //获取tbody的所有的行
		
		  var trs = $("#foodsbody").children();
		  //遍历行
		  var s = 0;
		  for(var i=0;i<trs.length;i++){
			  //获取该行下所有的td			  
	    			//获取本行内第4个td的内容
	    			var mny = trs.eq(i).children().eq(3).html();
	    			s += parseFloat(mny);
		  }
	    		
	    		//将结果写入合计列
			  var a = document.getElementById("total");
	    		a.innerHTML=s;
		  
	}
		  
	/* 删除整页所选项 */
	function removeAll () {
		if(!confirm("是否确定清空购物车?")) {
			return;
		}
		$("#foodsbody").empty();
		//改变背景颜色
		var trs = $('#table_body').children();
		for(i=0;i<trs.length;i++) {
			var num =$(trs[i]).children().length;//获取每个tr中td的个数
			for(j=0;j<num;j++) {
				var tds = $(trs[i]).children().eq(j);//获取每个td						
					$(tds).css("background","");//改变背景颜色			
			}
		}
		sumAll();
		readtr();
	}
	
	
	
	