$(function(){
	$('#ss').click(ss);
});
function ss(){
	$.ajax({
		"url":"addcuisine.go",
		"type":"get",
		"dataType":"json",
		"data":"sname="+$('#sname').val(),
		"success":function(data){
			$('#tb').empty(); //追加之前先清空
			for(var i=0;i<data.length;i++){
				var s = data[i];
				$('#tb').append('<tr><td>'+s.id+'</td><td>'+s.yname+'</td><td>'+s.price+'</td><td>'+s.num+'</td><td>'+s.update_time+'</td><td>'+s.path+'</td><td>'+s.no+'</td><td>'+s.search+'</td><td><input class="update" type="radio" name="ss'+s.no+'">修改</td><td><input class="delete" type="radio" name="ss'+s.no+'">删除</td></tr>');
			}
		}
	});
}
	