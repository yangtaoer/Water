$(function(){
		$('#ss').click(function(){
			$("#pageId").data("pageCurrent",1);
			ss();
		});
		$('#dc').click(function(){
			$("#pageId").data("pageCurrent",1);
			dc();
		});
		$('#dd').click(function(){
			$("#pageId").data("pageCurrent",1);
			dd();
		});
		$('#dp').click(function(){
			$("#pageId").data("pageCurrent",1);
			dp();
		});
		$('#wc').click(function(){
			$("#pageId").data("pageCurrent",1);
			wc();
		});
		$('#wd').click(function(){
			$("#pageId").data("pageCurrent",1);
			wd();
		});
		$('#wp').click(function(){
			$("#pageId").data("pageCurrent",1);
			wp();
		});
		$('#mc').click(function(){
			$("#pageId").data("pageCurrent",1);
			mc();
		});
		$('#md').click(function(){
			$("#pageId").data("pageCurrent",1);
			md();
		});
		$('#mp').click(function(){
			$("#pageId").data("pageCurrent",1);
			mp();
		});
	});
    $(document).ready(function(){
	    dc();
    })
	function ss(){
    	params={};
		var pageCurrent=$("#pageId").data("pageCurrent");
		//在pageId上绑定页面信息，以便分页执行
		$("#pageId").data("pageMessage","ss");
		if(!pageCurrent)pageCurrent=1;
		params.pageCurrent=pageCurrent;
		params.sname=$('#sname').val();
		$.ajax({
			"url":"ss.go",
			"type":"get",
			"dataType":"json",
			"data":params,
			"success":function(result){
				if(result.state==1){
	               	 setTableBodyRow(result.data.list);
			         setPagination(result.data.pageObject); 
	            }else if(result.state==0){
	               	 alert(result.message);
	            }
			}
		});
	}
	function dc(){
		params={};
		var pageCurrent=$("#pageId").data("pageCurrent");
		//在pageId上绑定页面信息，以便分页执行
		$("#pageId").data("pageMessage","dc");
		if(!pageCurrent)pageCurrent=1;
		params.pageCurrent=pageCurrent;
		$.ajax({
			"url":"day_cuisine.go",
			"type":"get",
			"dataType":"json",
			"data":params,
			"success":function(result){
				if(result.state==1){
	               	 setTableBodyRow(result.data.list);
			         setPagination(result.data.pageObject); 
	            }else if(result.state==0){
	               	 alert(result.message);
	            }
			}
		});
	}
	function setTableBodyRow(data){
		$('#tb').empty(); //追加之前先清空
		for(var i=0;i<data.length;i++){
			var s = data[i];
			$('#tb').append('<tr><td>'+s.no+'</td><td>'+s.yname+'</td><td>'+s.price+'</td><td>'+s.s+'</td><td>'+s.m+'</td></tr>');
		}
	}
	function dd(){
		params={};
		var pageCurrent=$("#pageId").data("pageCurrent");
		//在pageId上绑定页面信息，以便分页执行
		$("#pageId").data("pageMessage","dd");
		if(!pageCurrent)pageCurrent=1;
		params.pageCurrent=pageCurrent;
		$.ajax({
			"url":"day_drinks.go",
			"type":"get",
			"dataType":"json",
			"data":params,
			"success":function(result){
				if(result.state==1){
	               	 setTableBodyRow(result.data.list);
			         setPagination(result.data.pageObject); 
	            }else if(result.state==0){
	               	 alert(result.message);
	            }
			}
		});
	}
	function dp(){
		params={};
		var pageCurrent=$("#pageId").data("pageCurrent");
		//在pageId上绑定页面信息，以便分页执行
		$("#pageId").data("pageMessage","dp");
		if(!pageCurrent)pageCurrent=1;
		params.pageCurrent=pageCurrent;
		$.ajax({
			"url":"day_pot.go",
			"type":"get",
			"dataType":"json",
			"data":params,
			"success":function(result){
				if(result.state==1){
	               	 setTableBodyRow(result.data.list);
			         setPagination(result.data.pageObject); 
	            }else if(result.state==0){
	               	 alert(result.message);
	            }
			}
		});
	}
	function wc(){
		params={};
		var pageCurrent=$("#pageId").data("pageCurrent");
		//在pageId上绑定页面信息，以便分页执行
		$("#pageId").data("pageMessage","wc");
		if(!pageCurrent)pageCurrent=1;
		params.pageCurrent=pageCurrent;
		$.ajax({
			"url":"week_cuisine.go",
			"type":"get",
			"dataType":"json",
			"data":params,
			"success":function(result){
				if(result.state==1){
	               	 setTableBodyRow(result.data.list);
			         setPagination(result.data.pageObject); 
	            }else if(result.state==0){
	               	 alert(result.message);
	            }
			}
		});
	}
	function wd(){
		params={};
		var pageCurrent=$("#pageId").data("pageCurrent");
		//在pageId上绑定页面信息，以便分页执行
		$("#pageId").data("pageMessage","wd");
		if(!pageCurrent)pageCurrent=1;
		params.pageCurrent=pageCurrent;
		$.ajax({
			"url":"week_drinks.go",
			"type":"get",
			"dataType":"json",
			"data":params,
			"success":function(result){
				if(result.state==1){
	               	 setTableBodyRow(result.data.list);
			         setPagination(result.data.pageObject); 
	            }else if(result.state==0){
	               	 alert(result.message);
	            }
			}
		});
	}
	function wp(){
		params={};
		var pageCurrent=$("#pageId").data("pageCurrent");
		//在pageId上绑定页面信息，以便分页执行
		$("#pageId").data("pageMessage","wp");
		if(!pageCurrent)pageCurrent=1;
		params.pageCurrent=pageCurrent;
		$.ajax({
			"url":"week_pot.go",
			"type":"get",
			"dataType":"json",
			"data":params,
			"success":function(result){
				if(result.state==1){
	               	 setTableBodyRow(result.data.list);
			         setPagination(result.data.pageObject); 
	            }else if(result.state==0){
	               	 alert(result.message);
	            }
			}
		});
	}
	function mc(){
		params={};
		var pageCurrent=$("#pageId").data("pageCurrent");
		//在pageId上绑定页面信息，以便分页执行
		$("#pageId").data("pageMessage","mc");
		if(!pageCurrent)pageCurrent=1;
		params.pageCurrent=pageCurrent;
		$.ajax({
			"url":"month_cuisine.go",
			"type":"get",
			"dataType":"json",
			"data":params,
			"success":function(result){
				if(result.state==1){
	               	 setTableBodyRow(result.data.list);
			         setPagination(result.data.pageObject); 
	            }else if(result.state==0){
	               	 alert(result.message);
	            }
			}
		});
	}
	function md(){
		params={};
		var pageCurrent=$("#pageId").data("pageCurrent");
		//在pageId上绑定页面信息，以便分页执行
		$("#pageId").data("pageMessage","md");
		if(!pageCurrent)pageCurrent=1;
		params.pageCurrent=pageCurrent;
		$.ajax({
			"url":"month_drinks.go",
			"type":"get",
			"dataType":"json",
			"data":params,
			"success":function(result){
				if(result.state==1){
	               	 setTableBodyRow(result.data.list);
			         setPagination(result.data.pageObject); 
	            }else if(result.state==0){
	               	 alert(result.message);
	            }
			}
		});
	}
	function mp(){
		params={};
		var pageCurrent=$("#pageId").data("pageCurrent");
		
		//在pageId上绑定页面信息，以便分页执行
		$("#pageId").data("pageMessage","mp");
		if(!pageCurrent)pageCurrent=1;
		params.pageCurrent=pageCurrent;
		$.ajax({
			"url":"month_pot.go",
			"type":"get",
			"dataType":"json",
			"data":params,
			"success":function(result){
				if(result.state==1){
	               	 setTableBodyRow(result.data.list);
			         setPagination(result.data.pageObject); 
	            }else if(result.state==0){
	               	 alert(result.message);
	            }
			}
		});
	}
	