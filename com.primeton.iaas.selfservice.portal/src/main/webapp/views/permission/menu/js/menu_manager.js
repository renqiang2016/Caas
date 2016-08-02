	var userGrid = new Datatable();
	
	function inituserGrid () {
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
                	 type:"POST"
                 }, 
                 "columns":[
                     {"data":"check"},
                     {"data":"name"},
                     {"data":"email"},
                     {"data":"tel"},
                     {"data":"createTime"},
                     {"render": render_getOperationHtml}
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
		$("#menuModal .modal-title").html("新建");
		$("#menuModal #saveBtn").css("display","");
		$("#menuModal #updateBtn").css("display","none");
    	$('#menuModal').modal('show');
	}
	
	function editRow(row){
		$("#menuModal .modal-title").html("编辑");
		$("#menuModal #saveBtn").css("display","none");
		$("#menuModal #updateBtn").css("display","");
		var data = userGrid.getRowData(row.id);		
    	formHelper.setData(data);
    	$('#menuModal').modal('show');
    	document.getElementById("password2").value=document.getElementById("password").value;
	}
	
	function deleteRow(row){
		var rowId = row.id;
		$.ajax({
    		url:contextPath+"/rest/permission/user/delete/"+rowId,
    		type:'GET',
    		dataType:'json',
    		success:function(ret){
    			$('#menuModal').modal('hide');
    			userGrid.reload();
    		},
    		error:function(ret){
    			alert("删除失败");
    		}
    		
    	});
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
        			$('#menuModal').modal('hide');
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
    	inituserGrid();
        $('#menuModal').on("hidden.bs.modal", function() {
        	$("#userForm")[0].reset();
        });
        formHelper = new FormHelper("userForm");
    });
