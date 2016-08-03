	var namespaceGrid = new Datatable();
	function initNamespaceGrid () {
		namespaceGrid.init({
            src: $("#pageNamespaceGrid"),
            onSuccess: function (grid) {
            },
            onError: function (grid) {
            },
            onDataLoad: function(grid) {
            },
            dataTable: {
                "dom": "<'row'<'col-md-8 col-sm-12 '<'table-group-actions '>><'col-md-4 col-sm-12 pull-right'f>r><t><'row'<'col-md-8 col-sm-12'i>>",
                "ajax": {
                	 url:contextPath+"/rest/caas/namespaces/list",
                	 type:"GET"
                 }, 
                 "columns":[
                     {"data":"check"},
                     {"data":"name"},
                     {"data":"cpu"},
                     {"data":"memory"},
                     {"data":"pods"},
                     {"data":"status"},
                     {"data":"createTime"},
                     {"data":"modifiedTime"},
                     {"render":render_getOperationHtml}
                 ]
                 /*"columns":[
                        {"data":"check"},
                        {"data":"data.metadata.name"},
                        {"data":"data.metadata.name"},
                        {"data":"data.metadata.name"},
                        {"render":render_getOperationHtml}
                    ]*/
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
	
	function addRow(){
		$("#namespaceModal .modal-title").html("新建");
		$("#namespaceModal #saveBtn").css("display","");
		$("#namespaceModal #updateBtn").css("display","none");
    	$('#namespaceModal').modal('show');
	}
	
	function doSave(type){
    	
		var data = formHelper.getData();
    	var url = contextPath+"/rest/caas/namespaces/add";
    	if(type && type == 'update'){
    		url = contextPath+"/rest/caas/namespaces/update";
    	}
    	$.ajax({
    		url:url,
    		type:'POST',
    		contentType:'application/json',
    		data:JSON.stringify({"namespace":data}),
    		dataType:'json',
    		success:function(ret){
    			$('#namespaceModal').modal('hide');
    			namespaceGrid.reload();
    		},
    		error:function(ret){
    			
    		}
    		
    	})
    }
	
	function deleteRow(row){
		if (confirm("确定删除？")) {
			var id = row.id;
			$.ajax({
	    		url:contextPath+"/rest/caas/namespaces/delete/"+id,
	    		type:'DELETE',
	    		dataType:'json',
	    		success:function(ret){
	    			$('#namespaceModal').modal('hide');
	    			namespaceGrid.reload();
	    		},
	    		error:function(ret){
	    			alert("删除失败");
	    		}
	    		
	    	});
		}
	}
	
	function editRow(row){
		$("#namespaceModal .modal-title").html("编辑");
		$("#namespaceModal #saveBtn").css("display","none");
		$("#namespaceModal #updateBtn").css("display","");
		var data = namespaceGrid.getRowData(row.id);		
    	formHelper.setData(data);
    	$('#namespaceModal').modal('show');
    	//name改成id
	}
	
	/*function editRow(row){
		$("#namespaceModal .modal-title").html("编辑");
		$("#namespaceModal #saveBtn").css("display","none");
		$("#namespaceModal #updateBtn").css("display","");
		var data = userGrid.getRowData(row.id);		
    	formHelper.setData(data);
    	$('#namespaceModal').modal('show');
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
    	
    }*/

    var formHelper;
    $(function(){
    	Metronic.init(); 
    	initNamespaceGrid();
        $('#namespaceModal').on("hidden.bs.modal", function() {
        	$("#namespaceForm")[0].reset();
        });
        formHelper = new FormHelper("namespaceForm");
    });
