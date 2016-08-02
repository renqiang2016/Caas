	var orderGrid = new Datatable();
	var orderItemGrid = new DatatableNoSearch();
	
	function initOrderGrid () {
		orderGrid.init({
            src: $("#orderGrid"),
            onSuccess: function (grid) {
            },
            onError: function (grid) {
            },
            onDataLoad: function(grid) {
            },
            dataTable: {
                "dom": "<'row'<'col-md-8 col-sm-12 '<'table-group-actions '>><'col-md-4 col-sm-12 pull-right'f>r><t><'row'<'col-md-8 col-sm-12'i>>",
                "ajax": {
                	 url:contextPath+"/rest/order/listApproval",
                	 type:"GET"
                 }, 
                 "columns":[
                     {"data":"check"},
                     {"data":"id"},
                     {"data":"status", "render": function(data, type, full, meta) {var array = ['待提交','已撤销','已拒绝','待审批','待处理','已处理']; return array[data];}},
                     {"data":"createTime"},
                     {"data":"modifiedTime"},
                     {"render": render_getOperationHtml}
                 ]
            }
        });
    }
	
	function initOrderItemGrid () {
		orderItemGrid.init({
            src: $("#orderItemGrid"),
            onSuccess: function (grid) {
            },
            onError: function (grid) {
            },
            onDataLoad: function(grid) {
            },
            dataTable: {
                "dom": "<'row'<'col-md-8 col-sm-12 '<'table-group-actions '>><'col-md-4 col-sm-12 pull-right'f>r><t><'row'<'col-md-8 col-sm-12'i>>",
                "ajax": {
                	 url:contextPath+"/rest/order/list/aaa/item",
                	 type:"GET"
                 }, 
                 "columns":[
                     {"data":"check"},
                     {"data":"name"},
                     {"data":"cpu"},
                     {"data":"memory"},
                     {"data":"pods"},
                     {"data":"comments"}
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
								+	'<li><a id="'+full.id+'" onclick="showRow(this)">详情</a></li>'
								+'</ul>'
							+'</div>';
		return OperationHtml;
	}

	function render_getType(data, type, full, meta){
		if(!isNaN(data)){
			var array = ['待提交','已撤销','已拒绝','待审批','待处理','已处理'];		
			return array[data];
		}else{
			return data;
		}

	}

	function showRow(row){
		$("#formModal .modal-title").html("详情");
		var data = orderGrid.getRowData(row.id);
		if(data['status']==3 || data['status']=="待审批"){
			$("#formModal #allowBtn").css("display","");
			$("#formModal #refuseBtn").css("display","");
		}else if(data['status']==4 || data['status']=="待处理"){
			$("#formModal #allowBtn").css("display","none");
			$("#formModal #refuseBtn").css("display","none");
		}else if(data['status']==5 || data['status']=="已处理"){
			$("#formModal #allowBtn").css("display","none");
			$("#formModal #refuseBtn").css("display","none");
		}
		data['status'] = render_getType(data['status']);
    	formHelper.setData(data);
    	$('#formModal').modal('show');
    	orderItemGrid.getDataTable().ajax.url(contextPath+"/rest/order/list/"+row.id+"/item").load();
	}
	   
    function doAllow(){
    	
		var data = formHelper.getData();
		data['status'] = 4;
    	var url = contextPath+"/rest/order/update";   	
    	$.ajax({
    		url:url,
    		type:'POST',
    		contentType:'application/json',
    		data:JSON.stringify({"order":data}),
    		dataType:'json',
    		success:function(ret){
    			$('#formModal').modal('hide');
    			orderGrid.reload();
    		},
    		error:function(ret){
    			
    		}
    		
    	})
    	   	
    }
    
    function doRefuse(){
    	
		var data = formHelper.getData();
		data['status'] = 2;
    	var url = contextPath+"/rest/order/update";   	
    	$.ajax({
    		url:url,
    		type:'POST',
    		contentType:'application/json',
    		data:JSON.stringify({"order":data}),
    		dataType:'json',
    		success:function(ret){
    			$('#formModal').modal('hide');
    			orderGrid.reload();
    		},
    		error:function(ret){
    			
    		}
    		
    	})
    	   	
    }
    
    var formHelper;
    $(function(){
    	Metronic.init(); 
    	initOrderGrid();
    	initOrderItemGrid();
        $('#formModal').on("hidden.bs.modal", function() {
        	$("#orderForm")[0].reset();
        });
       
        formHelper = new FormHelper("orderForm");
    });
