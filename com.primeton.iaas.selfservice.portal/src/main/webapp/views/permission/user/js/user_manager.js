	var userGrid = new Datatable();
	var userRoleGrid1 = new DatatableNoSearch();
	var userRoleGrid2 = new DatatableNoSearch();
	
	function initUserGrid () {
		userGrid.init({
            src: $("#permissionUserGrid"),
            onSuccess: function (grid) {
            },
            onError: function (grid) {
            },
            onDataLoad: function(grid) {
            },
            dataTable: {
                "dom": "<'row'<'col-md-8 col-sm-12 '<'table-group-actions '>><'col-md-4 col-sm-12 pull-right'f>r><t><'row'<'col-md-8 col-sm-12'i>>",
                "ajax": {
                	 url:contextPath+"/rest/permission/user/list",
                	 type:"GET"
                 }, 
                 "columns":[
                     {"data":"check"},
                     {"data":"name"},
                     {"data":"gender"},
                     {"data":"tel"},
                     {"data":"email"},
                     {"data":"createTime"},
                     {"data":"modifiedTime"},
                     {"render": render_getOperationHtml}
                 ]
            }
        });
    }
	
	function initUserRoleGrid1 () {
		userRoleGrid1.init({
            src: $("#table1"),
            onSuccess: function (grid) {
            },
            onError: function (grid) {
            },
            onDataLoad: function(grid) {
            },
            dataTable: {
                "dom": "<'row'<'col-md-8 col-sm-12 '<'table-group-actions '>><'col-md-4 col-sm-12 pull-right'f>r><t><'row'<'col-md-8 col-sm-12'i>>",
                "ajax": {
                	 url:contextPath+"/rest/permission/user/list/aaa/NoAuthRole",
                	 type:"GET"
                 }, 
                 "columns":[
                     {"data":"check"},
                     {"data":"code"},
                     {"data":"name"}
                 ]
            }
        });
    }
	
	function initUserRoleGrid2 () {
		userRoleGrid2.init({
            src: $("#table2"),
            onSuccess: function (grid) {
            },
            onError: function (grid) {
            },
            onDataLoad: function(grid) {
            },
            dataTable: {
                "dom": "<'row'<'col-md-8 col-sm-12 '<'table-group-actions '>><'col-md-4 col-sm-12 pull-right'f>r><t><'row'<'col-md-8 col-sm-12'i>>",
                "ajax": {
                	 url:contextPath+"/rest/permission/user/list/aaa/AuthRole",
                	 type:"GET"
                 }, 
                 "columns":[
                     {"data":"check"},
                     {"data":"code"},
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
		var rows= userRoleGrid1.getSelectedRows();
		if (userRoleGrid1.getSelectedRowsCount()==0) {
			alert("没有选中角色项！");
		} else if(userRoleGrid1.getSelectedRowsCount()>1){
			alert("每个用户只能授予一个角色！");
		}else {
			
			userRoleGrid1.getDataTable().rows('tr:has(span.checked)').remove().draw();
			userRoleGrid1.getDataTable().rows.add(userRoleGrid2.getDataTable().data()).draw();
			userRoleGrid2.getDataTable().clear().draw();
			
			userRoleGrid2.getDataTable().rows.add(rows).draw();
			
		}
		
	}
	
	function removes(){
		var rows= userRoleGrid2.getSelectedRows();
		if (userRoleGrid2.getSelectedRowsCount()==0) {
			alert("没有选中角色项！");
		} else {			
			userRoleGrid2.getDataTable().rows('tr:has(span.checked)').remove().draw();
			userRoleGrid1.getDataTable().rows.add(rows).draw();
		}
	}	
	
	function addRow(){
		$("#userModal .modal-title").html("新建");
		$("#userModal #saveBtn").css("display","");
		$("#userModal #updateBtn").css("display","none");
    	$('#userModal').modal('show');
	}
	
	function editRow(row){
		$("#userModal .modal-title").html("编辑");
		$("#userModal #saveBtn").css("display","none");
		$("#userModal #updateBtn").css("display","");
		var data = userGrid.getRowData(row.id);		
    	formHelper.setData(data);
    	$('#userModal').modal('show');
    	document.getElementById("password2").value=document.getElementById("password").value;
	}
	
	var userId;
	function auth(row){
		$("#formModalAuth .modal-title").html("授权");
		userRoleGrid1.getDataTable().clear().draw();
		userRoleGrid2.getDataTable().clear().draw();
		userRoleGrid1.getDataTable().ajax.url(contextPath+"/rest/permission/user/list/"+row.id+"/NoAuthRole").load();
    	userRoleGrid2.getDataTable().ajax.url(contextPath+"/rest/permission/user/list/"+row.id+"/AuthRole").load();
		$('#formModalAuth').modal('show');

		userId=row.id;
	}
	
	
	function deleteRow(row){
		if (confirm("确定删除？")) {
			var rowId = row.id;
			$.ajax({
	    		url:contextPath+"/rest/permission/user/delete/"+rowId,
	    		type:'DELETE',
	    		dataType:'json',
	    		success:function(ret){
	    			$('#userModal').modal('hide');
	    			userGrid.reload();
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
	
	function checkpassword(){
    	var password = document.getElementById("password").value;
    	var password2 = document.getElementById("password2").value;
    	if(password == password2){
    		return true;
		}else{
			window.alert("两次输入密码不一致");
			return false;
		}
	}

    function doSave(type){
    	if(checkpassword()){
    		var data = formHelper.getData();
        	var url = contextPath+"/rest/permission/user/add";
        	if(type && type == 'update'){
        		url = contextPath+"/rest/permission/user/update";
        	}
        	$.ajax({
        		url:url,
        		type:'POST',
        		contentType:'application/json',
        		data:JSON.stringify({"user":data}),
        		dataType:'json',
        		success:function(ret){
        			$('#userModal').modal('hide');
        			userGrid.reload();
        		},
        		error:function(ret){
        			
        		}
        		
        	})
    	}
    	
    }
    
    function doSaveAuth(){
		var roleId = $.map(userRoleGrid2.getDataTable().data(), function(val, key) { return val.id; });

		if(roleId.length==0){
			deleteAuth(userId);
		}else{
			var url = contextPath+"/rest/permission/user/add/AuthRole";        	
	    	$.ajax({
	    		url:url,
	    		type:'POST',
	    		contentType:'application/json',
	    		data:JSON.stringify({"userRole":{"roleId":roleId[0],"userId":userId}}),
	    		dataType:'json',
	    		success:function(ret){
	    			$('#formModalAuth').modal('hide');
	    			userGrid.reload();
	    		},
	    		error:function(ret){
	    			
	    		}
	    		
	    	})
		}
    	   	
    }
    
    function deleteAuth(userId){
    	$.ajax({
    		url:contextPath+"/rest/permission/user/delete/"+userId+"/AuthRole",
    		type:'DELETE',
    		dataType:'json',
    		success:function(ret){ 
    			$('#formModalAuth').modal('hide');
    			userGrid.reload();
    		},
    		error:function(ret){
    		}
    		
    	});
    }
    
    var formHelper;
    $(function(){
    	Metronic.init(); 
    	initUserGrid();
    	initUserRoleGrid1();
    	initUserRoleGrid2();
        $('#userModal').on("hidden.bs.modal", function() {
        	$("#userForm")[0].reset();
        });
        formHelper = new FormHelper("userForm");
    });
