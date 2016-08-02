	var roleGrid = new Datatable();
	var roleFuncGrid1 = new DatatableNoSearch();
	var roleFuncGrid2 = new DatatableNoSearch();
	function initRoleGrid () {
		roleGrid.init({
            src: $("#permissionRoleGrid"),
            onSuccess: function (grid) {
            },
            onError: function (grid) {
            },
            onDataLoad: function(grid) {
            },
            dataTable: {
                "dom": "<'row'<'col-md-8 col-sm-12 '<'table-group-actions '>><'col-md-4 col-sm-12 pull-right'f>r><t><'row'<'col-md-8 col-sm-12'i>>",
                "ajax": {
                	 url:contextPath+"/rest/permission/role/list",
                	 type:"GET"
                 }, 
                 "columns":[
                     {"data":"check"},
                     {"data":"name"},
                     {"data":"createTime"},
                     {"data":"modifiedTime"},
                     {"render": render_getOperationHtml}
                 ]
            }
        });
    }
	
	function initRoleFuncGrid1 () {
		roleFuncGrid1.init({
            src: $("#table1"),
            onSuccess: function (grid) {
            },
            onError: function (grid) {
            },
            onDataLoad: function(grid) {
            },
//            idField:"functionId",
            dataTable: {
                "dom": "<'row'<'col-md-8 col-sm-12 '<'table-group-actions '>><'col-md-4 col-sm-12 pull-right'f>r><t><'row'<'col-md-8 col-sm-12'i>>",
                "ajax": {
                	 url:contextPath+"/rest/permission/role/list/aaa/NoAuthFunc",
                	 type:"GET"
                 }, 
                 "columns":[
                     {"data":"check"},
                     {"data":"id"},
                     {"data":"name"}
                 ]
            }
        });
    }
	
	function initRoleFuncGrid2 () {
		roleFuncGrid2.init({
            src: $("#table2"),
            onSuccess: function (grid) {
            },
            onError: function (grid) {
            },
            onDataLoad: function(grid) {
            },
//            idField:"functionId",
            dataTable: {
                "dom": "<'row'<'col-md-8 col-sm-12 '<'table-group-actions '>><'col-md-4 col-sm-12 pull-right'f>r><t><'row'<'col-md-8 col-sm-12'i>>",
                "ajax": {
                	 url:contextPath+"/rest/permission/role/list/aaa/AuthFunc",
                	 type:"GET"
                 }, 
                 "columns":[
                     {"data":"check"},
                     {"data":"id"},
                     {"data":"name"}
                 ]
            }
        });
    }
    
	function render_getOperationHtml(data, type, full, meta){
		var OperationHtml = '<div class="btn-group pull-right">'
								+'<button type="button" class="btn btn-fit-height grey-salt dropdown-toggle grid-dropdown"'
								+	'data-toggle="dropdown" data-hover="dropdown" data-delay="1000" data-close-others="true">'
								+	'操作 <i class="fa fa-angle-down"></i>'
								+'</button>'
								+'<ul class="dropdown-menu pull-right" role="menu">'
								+	'<li><a id="'+full.id+'" onclick="editRow(this)">编辑</a></li>'
								+	'<li><a id="'+full.id+'" onclick="auth(this)">授权</a></li>'
								+	'<li><a id="'+full.id+'" onclick="deleteRow(this)">删除</a></li>'
								+'</ul>'
							+'</div>';
		return OperationHtml;
	}
	
	function render_getType(data, type, full, meta){
		var array = ['指标','事件'];
		return array[data];
	}
	
	function add(){		
		var rows = roleFuncGrid1.getSelectedRows();
		if (roleFuncGrid1.getSelectedRowsCount()==0) {
			alert("没有选中角色项！");
		} else {			
			roleFuncGrid1.getDataTable().rows('tr:has(span.checked)').remove().draw();
			roleFuncGrid2.getDataTable().rows.add(rows).draw();
		}
		
	}
	
	function removes(){
		var rows = roleFuncGrid2.getSelectedRows();
		if (roleFuncGrid2.getSelectedRowsCount()==0) {
			alert("没有选中角色项！");
		} else {			
			roleFuncGrid2.getDataTable().rows('tr:has(span.checked)').remove().draw();			
			roleFuncGrid1.getDataTable().rows.add(rows).draw();			
		}
	}	
	
	var roleId;
	function auth(row){
		$("#formModalAuth .modal-title").html("授权");
		roleFuncGrid1.getDataTable().clear().draw();
		roleFuncGrid2.getDataTable().clear().draw();
		roleFuncGrid1.getDataTable().ajax.url(contextPath+"/rest/permission/role/list/"+row.id+"/NoAuthFunc").load();
		roleFuncGrid2.getDataTable().ajax.url(contextPath+"/rest/permission/role/list/"+row.id+"/AuthFunc").load();
		$('#formModalAuth').modal('show');

		roleId=row.id;
	}
	
	function doSaveAuth(){
		var functionIds = $.map(roleFuncGrid2.getDataTable().data(), function(val, key) { return val.id; });

		if(functionIds.length==0){
			deleteAuth(roleId);
		}else{
			var url = contextPath+"/rest/permission/role/function/add";        	
	    	$.ajax({
	    		url:url,
	    		type:'POST',
	    		contentType:'application/json',
	    		data:JSON.stringify({"functionIds":functionIds,"roleId":roleId}),
	    		dataType:'json',
	    		success:function(ret){
	    			$('#formModalAuth').modal('hide');
	    			roleGrid.reload();
	    		},
	    		error:function(ret){
	    			
	    		}
	    		
	    	})
		}
	}
	
	function deleteAuth(roleId){
    	$.ajax({
    		url:contextPath+"/rest/permission/role/function/delete/"+roleId,
    		type:'DELETE',
    		dataType:'json',
    		success:function(ret){ 
    			$('#formModalAuth').modal('hide');
    			roleGrid.reload();
    		},
    		error:function(ret){
    		}
    		
    	});
    }
	
	function addRow(){
		$("#roleModal .modal-title").html("新建");
		$("#roleModal #saveBtn").css("display","");
		$("#roleModal #updateBtn").css("display","none");
    	$('#roleModal').modal('show');
	}
	
	function editRow(row){
		$("#roleModal .modal-title").html("编辑");
		$("#roleModal #saveBtn").css("display","none");
		$("#roleModal #updateBtn").css("display","");
		var data = roleGrid.getRowData(row.id);		
    	formHelper.setData(data);
    	$('#roleModal').modal('show');
	}
	
	function deleteRow(row){
		if (confirm("确定删除？")) {
			var rowId = row.id;
			$.ajax({
	    		url:contextPath+"/rest/permission/role/delete/"+rowId,
	    		type:'DELETE',
	    		dataType:'json',
	    		success:function(ret){
	    			$('#roleModal').modal('hide');
	    			roleGrid.reload();
	    		},
	    		error:function(ret){
	    			alert("删除失败");
	    		}
	    		
	    	});
		}
	}
	
	
	
	function doUpdate(){
		doSave("update");
	}
	
    function doSave(type){
    	
		var data = formHelper.getData();
    	var url = contextPath+"/rest/permission/role/add";
    	if(type && type == 'update'){
    		url = contextPath+"/rest/permission/role/update";
    	}
    	$.ajax({
    		url:url,
    		type:'POST',
    		contentType:'application/json',
    		data:JSON.stringify({"role":data}),
    		dataType:'json',
    		success:function(ret){
    			$('#roleModal').modal('hide');
    			roleGrid.reload();
    		},
    		error:function(ret){
    			
    		}
    		
    	})
    	
    	
    }
    
    var formHelper;
    $(function(){
    	Metronic.init(); 
    	initRoleGrid();
    	initRoleFuncGrid1();
    	initRoleFuncGrid2();
        $('#roleModal').on("hidden.bs.modal", function() {
        	$("#roleForm")[0].reset();
        });
        formHelper = new FormHelper("roleForm");
    });
