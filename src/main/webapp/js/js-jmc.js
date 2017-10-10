
/**
 * 自动生成购物车
 */
	function fonclick(btn){
		btn.style.backgroundColor="#abcdef";
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
			var name = trs.eq(i).children().eq(0).html();
			console.log(name);
			if(foodname==name){
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
		$("#foodsbody").append(new_trs);
		sumAll();
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
	}
	/*删除一行*/
	function remove(btn) {
		$(btn).parent().parent().remove();
		sumAll();
		//修改背景颜色
	}
	//计算总价格
	function sumAll() {
		  //获取tbody的所有的行
		
		  var trs = $("#foodsbody").children();
		  //遍历行
		  var s = 0;
		  console.log(trs);
		  
		  for(var i=0;i<trs.length;i++){
			  //获取该行下所有的td
			  
	    			//获取本行内第4个td的内容
	    			var mny = trs.eq(i).children().eq(3).html();
	    			console.log(mny);
	    			s += parseFloat(mny);
		  }
	    		
	    		//将结果写入合计列
			  var a = document.getElementById("total");
	    		a.innerHTML=s;
		  
	}
		  
	/* 删除整页所选项 */
	function removeAll () {
		var a = document.getElementById("foodsbody");
		confirm("是否确定清空购物车?");
		a.innerHTML = "";
		sumAll();
		
	}
	
	
	
	