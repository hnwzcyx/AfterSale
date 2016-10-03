$(document).ready(function(){
	$('#table').bootstrapTable({
		url:'',
	    columns: [{
	    	checkbox:true
	    },{
	        field: 'id',
	        title: '序号'
	    }, {
	        field: 'loginAccount',
	        title: '用户名'
	    }, {
	        field: 'name',
	        title: '姓名'
	    }, {
	        field: 'email',
	        title: '邮箱'
	    }, {
	        field: 'roles.0.name',
	        title: '角色'
	    }],
	    pagination:true,
	    pageSize:10,
	    search:true,
	    showToggle:true,
	    checkbox:true,
	    toolbar:"#toolbar",
	});


});