	var rcsGrid = new Datatable();
	function initrcsGrid () {
		rcsGrid.init({
            src: $("#pageReplicationControllersGrid"),
            onSuccess: function (grid) {
            },
            onError: function (grid) {
            },
            onDataLoad: function(grid) {
            },
            dataTable: {
                "dom": "<'row'<'col-md-8 col-sm-12 '<'table-group-actions '>><'col-md-4 col-sm-12 pull-right'f>r><t><'row'<'col-md-8 col-sm-12'i>>",
                "ajax": {
                	 url:contextPath+"/rest/caas/replicationcontrollers/lists",
                	 type:"GET"
                 }, 
                 "columns":[
                     {"data":"check"},
                     {"data":"id"},
                     {"data":"namespace"},
                     {"data":"labels"},
                     {"data":"selector"},
                     {"data":"replicas"},
                     {"data":"image"},
                     {"data":"restartPolicy"},
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
		$("#replicationModal .modal-title").html("新建");
    	$('#replicationModal').modal('show');
	}
	
    function doSave(){
    	/*$("#uploadForm").submit();
    	$.ajax({
    		url:contextPath+"/rest/caas/replicationcontrollers/add",
    		type:'POST',
    		dataType:'json',
    		success:function(ret){ 
    			$('#replicationModal').modal('hide');
    			alert("创建成功！");
    		},
    		error:function(ret){
    			alert("创建失败！");
    		}
    		
    	});*/
    	/*$.ajax({
    		cache: true,
    		type: "POST",
    		url:contextPath+"/UploadHandleServlet",
    		data:$('#uploadForm').serialize(),// 你的formid
    		async: false,
    		error: function(request) {
    			alert("创建失败！");
    		},
    		success: function(data) {
    			alert("创建成功！");
    			$("#commonLayout_appcreshi").parent().html(data);
    		}
    	});*/
    	var formData = new FormData($( "#uploadForm" )[0]);  
        $.ajax({  
             url: contextPath+"/UploadHandleServlet" ,  
             type: 'POST',  
             data: formData,  
             async: false,  
             cache: false,  
             contentType: false,  
             processData: false,  
             success: function (returndata) {  
            	 $('#replicationModal').modal('hide');
     			 alert("创建成功！"); 
             },  
             error: function (returndata) {  
            	 alert("创建失败！");  
             }  
        });
    	
    }
    var formHelper;
    $(function(){
    	Metronic.init(); 
    	initrcsGrid();
        $('#replicationModal').on("hidden.bs.modal", function() {
        	$("#replicationForm")[0].reset();
        });
        formHelper = new FormHelper("replicationForm");
    });
