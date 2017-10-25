$(function(){
		$('#ss').click(function(){
			$("#pageId").data("pageCurrent",1);
			ss();
		});
		$('#di').click(function(){
			$("#pageId").data("pageCurrent",1);
			di();
		});
		$('#wi').click(function(){
			$("#pageId").data("pageCurrent",1);
			wi();
		});
		$('#mi').click(function(){
			$("#pageId").data("pageCurrent",1);
			mi();
		});
	});
    $(document).ready(function(){
	    di();
    })
	function ss(){
    	params={};
		var pageCurrent=$("#pageId").data("pageCurrent");
		//在pageId上绑定页面信息，以便分页执行
		$("#pageId").data("pageMessage","ss");
		if(!pageCurrent)pageCurrent=1;
		params.pageCurrent=pageCurrent;
		params.no=$('#sname').val();
		$.ajax({
			"url":"si.go",
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
	function di(){
		params={};
		var pageCurrent=$("#pageId").data("pageCurrent");
		//在pageId上绑定页面信息，以便分页执行
		$("#pageId").data("pageMessage","di");
		if(!pageCurrent)pageCurrent=1;
		params.pageCurrent=pageCurrent;
		
		$.ajax({
			"url":"di.go",
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
	function wi(){
		params={};
		var pageCurrent=$("#pageId").data("pageCurrent");
		//在pageId上绑定页面信息，以便分页执行
		$("#pageId").data("pageMessage","wi");
		if(!pageCurrent)pageCurrent=1;
		params.pageCurrent=pageCurrent;
		$.ajax({
			"url":"wi.go",
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
	function mi(){
		params={};
		var pageCurrent=$("#pageId").data("pageCurrent");
		//在pageId上绑定页面信息，以便分页执行
		$("#pageId").data("pageMessage","mi");
		if(!pageCurrent)pageCurrent=1;
		params.pageCurrent=pageCurrent;
		$.ajax({
			"url":"mi.go",
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
			$('#tb').append('<tr><td>'+s.num1+'</td><td>'+s.consumption+'</td><td>'+s.money+'</td></tr>');
		}
	}
	
	