	$(function(){
		$('#ss').click(function(){
			$("#pageId").data("pageCurrent",1);
			ss();
		});
		$('#ny').click(function(){
			$("#pageId").data("pageCurrent",1);
			ny();
		});
		$('#dm').click(function(){
			$("#pageId").data("pageCurrent",1);
			dm();
		});
		$('#jg').click(function(){
			$("#pageId").data("pageCurrent",1);
			jg();
		});
		$('#hx').click(function(){
			$("#pageId").data("pageCurrent",1);
			hx();
		});
		$('#jd').click(function(){
			$("#pageId").data("pageCurrent",1);
			jd();
		});
		$('#wz').click(function(){
			$("#pageId").data("pageCurrent",1);
			wz();
		});
		$('#sc').click(function(){
			$("#pageId").data("pageCurrent",1);
			xxsc();
		});
		$('#gd').click(function(){
			$("#pageId").data("pageCurrent",1);
			gd();
		});
		$('#js').click(function(){
			$("#pageId").data("pageCurrent",1);
			js();
		});

		$("#delete1").click(getTDtext);
		$("#update1").click(newcp);
	});
	$(document).ready(function(){
		ny();
	})
	function ss(){
		params={};
		var pageCurrent=$("#pageId").data("pageCurrent");
		//在pageId上绑定页面信息，以便分页执行
		$("#pageId").data("pageMessage","sc");
		if(!pageCurrent)pageCurrent=1;
		params.pageCurrent=pageCurrent;
		if($('#sname').val()==""){
			alert("请先输入");
			return;
		}
		params.sname=$('#sname').val();
		$.ajax({
			"url":"sc.go",
			"type":"get",
			"dataType":"json",
			"data":params,
			"success":function(result){
				if(result.state==1){
	               	 setTableBodyRows(result.data.list);
			         setPagination(result.data.pageObject); 
	                }else if(result.state==0){
	               	 alert(result.message);
	                }
			}
		});
	}
	function getTDtext(){
		var nos =""; 
		$("input[name='test']")//迭代input对象
		  .each(function(){//each函数用于迭代一个数组
			  if($(this).prop("checked")){//判定此input对象是否是选中的
				  var no = $(this).parent().siblings("#z").html();
				  if(nos==""){
					  nos+=no;
				  }else{
					  nos+=","+no
				  }
			  }
		  });
		  if(nos==""){
			  alert("请至少选择一个");
			  return;
		  }
		  $.get({
				"url":"a.go",
				"type":"get",
				"dataType":"json",
				"data":"nos="+nos,
			});
	}
	function newcp(){
		var nos =""; 
		$("input[name='test']")//迭代input对象
		  .each(function(){//each函数用于迭代一个数组
			  if($(this).prop("checked")){//判定此input对象是否是选中的
				  var no = $(this).parent().siblings("#z").html();
				  if(nos==""){
					  nos+=no;
				  }else{
					  nos+=","+no
				  }
			  }
		  });
		  if(nos==""){
			  alert("请至少选择一个");
			  return;
		  }
		  window.location.href='newcp.go?nos='+nos;
	}
	/*
	function del(){
		console.log(1);
		$.ajax({
			"url":"deleteCuisine.go",
			"type":"get",
			"dataType":"json",
			"data":"no="+getTDtext(),
			"success":function(data){
				inserttable();	
			}
		});
	}
	*/
	function ny(){
		params={};
		var pageCurrent=$("#pageId").data("pageCurrent");
		//在pageId上绑定页面信息，以便分页执行
		$("#pageId").data("pageMessage","ny");
		if(!pageCurrent)pageCurrent=1;
		params.pageCurrent=pageCurrent;
		$.ajax({
			"url":"ny.go",
			"type":"get",
			"dataType":"json",
			"data":params,
			"success":function(result){
				if(result.state==1){
	               	 setTableBodyRows(result.data.list);
			         setPagination(result.data.pageObject); 
	                }else if(result.state==0){
	               	 alert(result.message);
	                }
			}
		});
	}
	function dm(){
		params={};
		var pageCurrent=$("#pageId").data("pageCurrent");
		//在pageId上绑定页面信息，以便分页执行
		$("#pageId").data("pageMessage","dm");
		if(!pageCurrent)pageCurrent=1;
		params.pageCurrent=pageCurrent;
		$.ajax({
			"url":"dm.go",
			"type":"get",
			"dataType":"json",
			"data":params,
			"success":function(result){
				if(result.state==1){
               	 setTableBodyRows(result.data.list);
		         setPagination(result.data.pageObject); 
                }else if(result.state==0){
               	 alert(result.message);
                }
			}
		});
	}
	/**菌菇*/
	function jg(){
		params={};
		var pageCurrent=$("#pageId").data("pageCurrent");
		//在pageId上绑定页面信息，以便分页执行
		$("#pageId").data("pageMessage","jg");
		if(!pageCurrent)pageCurrent=1;
		params.pageCurrent=pageCurrent;
		$.ajax({
			"url":"jg.go",
			"type":"get",
			"dataType":"json",
			"data":params,
			"success":function(result){
				console.log(result);
                 if(result.state==1){
                	 setTableBodyRows(result.data.list);
 		        	setPagination(result.data.pageObject); 
                 }else if(result.state==0){
                	 alert(result.message);
                 }
					
				
			
			}
		});
	}
	function setTableBodyRows(data){
		$('#tb').empty(); //追加之前先清空
		for(var i=0;i<data.length;i++){
			var s = data[i];
			$('#tb').append('<tr><td><input type="checkbox" name="test"></td><td>'+
					s.yname+'</td><td>'+s.price+'</td><td>'+
					s.num+'</td><td>'+s.update_time+'</td><td>'+s.path+'</td><td id="z">'+s.no+'</td><td>'+s.search+'</td></tr>');
		}
	}
	
	function hx(){
		params={};
		var pageCurrent=$("#pageId").data("pageCurrent");
		//在pageId上绑定页面信息，以便分页执行
		$("#pageId").data("pageMessage","hx");
		if(!pageCurrent)pageCurrent=1;
		params.pageCurrent=pageCurrent;
		$.ajax({
			"url":"hx.go",
			"type":"get",
			"dataType":"json",
			"data":params,
			"success":function(result){
				 if(result.state==1){
                	 setTableBodyRows(result.data.list);
 		        	setPagination(result.data.pageObject); 
                 }else if(result.state==0){
                	 alert(result.message);
                 }
			}
		});
	}
	function jd(){
		params={};
		var pageCurrent=$("#pageId").data("pageCurrent");
		//在pageId上绑定页面信息，以便分页执行
		$("#pageId").data("pageMessage","jd");
		if(!pageCurrent)pageCurrent=1;
		params.pageCurrent=pageCurrent;
		$.ajax({
			"url":"jd.go",
			"type":"get",
			"dataType":"json",
			"data":params,
			"success":function(result){
				if(result.state==1){
               	 setTableBodyRows(result.data.list);
		        	setPagination(result.data.pageObject); 
                }else if(result.state==0){
               	 alert(result.message);
                }
			
			}
		});
	}
	function wz(){
		params={};
		var pageCurrent=$("#pageId").data("pageCurrent");
		//在pageId上绑定页面信息，以便分页执行
		$("#pageId").data("pageMessage","wz");
		if(!pageCurrent)pageCurrent=1;
		params.pageCurrent=pageCurrent;
		$.ajax({
			"url":"wz.go",
			"type":"get",
			"dataType":"json",
			"data":params,
			"success":function(result){
				if(result.state==1){
	               	 setTableBodyRows(result.data.list);
			        	setPagination(result.data.pageObject); 
	                }else if(result.state==0){
	               	 alert(result.message);
	                }
			}
		});
	}
	function xxsc(){
		var params={};
		var pageCurrent = $("#pageId").data("pageCurrent");
		//在pageId上绑定页面信息，以便分页执行
		$("#pageId").data("pageMessage","xxsc");
		if(pageCurrent)pageCurrent=1;
		params.pageCurrent=pageCurrent;
		$.ajax({
			"url":"xxsc.go",
			"type":"get",
			"dataType":"json",
			"data":params,
			"success":function(result){
				 if(result.state==1){
                	 setTableBodyRows(result.data.list);
 		        	setPagination(result.data.pageObject); 
                 }else if(result.state==0){
                	 alert(result.message);
                 }
			}
		});
	}
	/**锅底*/
	function gd(){
		var params={};
		var pageCurrent = $("#pageId").data("pageCurrent");
		//在pageId上绑定页面信息，以便分页执行
		$("#pageId").data("pageMessage","gd");
		if(pageCurrent)pageCurrent=1;
		params.pageCurrent=pageCurrent;
		$.ajax({
			"url":"gd.go",
			"type":"get",
			"dataType":"json",
			"data":params,
			"success":function(result){
				 if(result.state==1){
                	 setTableBodyRows(result.data.list);
 		        	setPagination(result.data.pageObject); 
                 }else if(result.state==0){
                	 alert(result.message);
                 }
				
			}
		});
	}
	function js(){
		params={};
		var pageCurrent=$("#pageId").data("pageCurrent");
		//在pageId上绑定页面信息，以便分页执行
		$("#pageId").data("pageMessage","js");
		if(!pageCurrent)pageCurrent=1;
		params.pageCurrent=pageCurrent;
		$.ajax({
			"url":"js.go",
			"type":"get",
			"dataType":"json",
			"data":params,
			"success":function(result){
				 if(result.state==1){					 
                	 setTableBodyRows(result.data.list);
 		        	setPagination(result.data.pageObject); 
                 }else if(result.state==0){
                	 alert(result.message);
                 }
			}
		});
	}
	