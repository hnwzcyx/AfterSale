$(document).ready(function(){
	$('#resorceTable').bootstrapTable({
		url:'system/resource_list.action',
	    columns: [{
	    	checkbox:true
	    },{
	        field: 'id',
	        title: '序号'
	    }, {
	        field: 'name',
	        title: '资源名'
	    }, {
	        field: 'url',
	        title: '地址'
	    }, {
	        field: 'iconCls',
	        title: '图标'
	    }],
	    pagination:true,
	    pageSize:10,
	    search:true,
	    showToggle:true,
	    checkbox:true,
	    detailView:true,
	    toolbar:"#toolbar",
        onExpandRow: function (index, row, $detail) {
        	expandTable($detail,row);
        }
	});
    function expandTable($detail,row) {
        buildTable($detail.html('<table></table>').find('table'),row);
    }
	function buildTable($el,row) {
	    $el.bootstrapTable({
	    	method:'post',
	    	/*queryParams:function (id){
	    		id=row.id;
	    		return id;
	    	},*/
	    	url:'system/resource_subList.action?id='+row.id,
	    	columns: [{
		    	checkbox:true
		    },{
		        field: 'id',
		        title: '序号'
		    }, {
		        field: 'name',
		        title: '资源名'
		    }, {
		        field: 'url',
		        title: '地址'
		    }, {
		        field: 'iconCls',
		        title: '图标'
		    }],
		    showHeader:false,
	    });
	}
});

