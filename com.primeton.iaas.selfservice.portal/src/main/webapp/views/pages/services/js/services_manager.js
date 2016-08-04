	var serviceGrid = new Datatable();
	function initServiceGrid () {
		serviceGrid.init({
            src: $("#pageServicesGrid"),
            onSuccess: function (grid) {
            },
            onError: function (grid) {
            },
            onDataLoad: function(grid) {
            },
            dataTable: {
                "dom": "<'row'<'col-md-8 col-sm-12 '<'table-group-actions '>><'col-md-4 col-sm-12 pull-right'f>r><t><'row'<'col-md-8 col-sm-12'i>>",
                "ajax": {
                	 url:contextPath+"/rest/caas/services/lists",
                	 type:"GET"
                 }, 
                 "columns":[
                     {"data":"check"},
                     {"data":"name"},
                     {"data":"namespace"},
                     {"data":"labels"},
                     {"data":"selector"},
                     {"data":"port"},
                     {"data":"targetPort"},
                     {"data":"nodePort"},
                     {"data":"createTime"},
                     {"render":render_getOperationHtml}
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
    	
    }

    var formHelper;
    $(function(){
    	Metronic.init(); 
    	initServiceGrid();
        $('#userModal').on("hidden.bs.modal", function() {
        	$("#userForm")[0].reset();
        });
        formHelper = new FormHelper("userForm");
    });
