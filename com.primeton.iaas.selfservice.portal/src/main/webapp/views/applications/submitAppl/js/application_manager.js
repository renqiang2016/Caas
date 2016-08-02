	var orderGrid = new Datatable();
	var orderItemGrid = new DatatableNoSearch();
/*	var existId = new Map();
	var i = 0;*/
	var userId = document.getElementById('userId').value ;
//	alert(userId);
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
                	 url:contextPath+"/rest/order/listUserOrders/"+userId,
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
	
/*	function id(data, type, full, meta){
		var id = data['id'];
		existId.put(id,id);
		return id;		

	}*/
	
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
                     {"data":"comments"},
                     {"render": render_getOperationHtml2}
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
	
	function render_getOperationHtml2(data, type, full, meta){
		var OperationHtml = '<div class="btn-group pull-right">'
								+'<button type="button" class="btn btn-fit-height grey-salt dropdown-toggle grid-dropdown"'
								+	'data-toggle="dropdown" data-hover="dropdown" data-delay="1000" data-close-others="true">'
								+	'操作 <i class="fa fa-angle-down"></i>'
								+'</button>'
								+'<ul class="dropdown-menu pull-right" role="menu">'
								+	'<li><a id="'+full.id+'" onclick="editRow(this)">编辑</a></li>'
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

	function addRow(){
		$("#formModal2 .modal-title").html("新建");
		$("#formModal2 #form-orderId").css("display","");
		$("#formModal2 #okBtn").css("display","none");
		$("#formModal2 #saveBtn").css("display","");
    	$('#formModal2').modal('show');
	}
	
	function editRow(row){
		$("#formModal2 .modal-title").html("编辑");
		$("#formModal2 #form-orderId").css("display","none");
		$("#formModal2 #okBtn").css("display","");
		$("#formModal2 #saveBtn").css("display","none");
		var data = orderItemGrid.getRowData(row.id);
		formHelper2.setData(data);
		$('#formModal2').modal('show');
		
	}
	
	var orderId;
	function showRow(row){
		$("#formModal .modal-title").html("详情");
		var data = orderGrid.getRowData(row.id);
		if(data['status']==0 || data['status']=="待提交"){
			$("#formModal #revokeBtn").css("display","none");
			$("#formModal #submitBtn").css("display","");
			$("#formModal #deleteBtn").css("display","");
		}else if(data['status']==1 || data['status']=="已撤销"){
			$("#formModal #revokeBtn").css("display","none");
			$("#formModal #submitBtn").css("display","");
			$("#formModal #deleteBtn").css("display","");
		}else if(data['status']==2 || data['status']=="已拒绝"){
			$("#formModal #revokeBtn").css("display","none");
			$("#formModal #submitBtn").css("display","");
			$("#formModal #deleteBtn").css("display","");
		}else if(data['status']==3 || data['status']=="待审批"){
			$("#formModal #revokeBtn").css("display","");
			$("#formModal #submitBtn").css("display","none");
			$("#formModal #deleteBtn").css("display","none");
		}else if(data['status']==4 || data['status']=="待处理"){
			$("#formModal #revokeBtn").css("display","");
			$("#formModal #submitBtn").css("display","none");
			$("#formModal #deleteBtn").css("display","none");
		}else if(data['status']==5 || data['status']=="已处理"){
			$("#formModal #revokeBtn").css("display","none");
			$("#formModal #submitBtn").css("display","none");
			$("#formModal #deleteBtn").css("display","none");
		}
		data['status'] = render_getType(data['status']);
    	formHelper.setData(data);
    	$('#formModal').modal('show');
    	orderItemGrid.getDataTable().ajax.url(contextPath+"/rest/order/list/"+row.id+"/item").load();
    	orderId = row.id;
	}
	
	function doDelete(){
		if (confirm("确定删除？")) {
			alert(orderId);
			$.ajax({
	    		url:contextPath+"/rest/order/delete/"+orderId,
	    		type:'DELETE',
	    		dataType:'json',
	    		success:function(ret){
	    			$('#formModal').modal('hide');
	    			orderGrid.reload();
	    		},
	    		error:function(ret){
	    			alert("删除失败");
	    		}
	    		
	    	});
		}
	}
	
    function doOk(){
    	
		var data = formHelper2.getData();
    	var url = contextPath+"/rest/order/update/item";   	
    	$.ajax({
    		url:url,
    		type:'POST',
    		contentType:'application/json',
    		data:JSON.stringify({"orderItem":data}),
    		dataType:'json',
    		success:function(ret){
    			$('#formModal2').modal('hide');
    			orderItemGrid.reload();
    		},
    		error:function(ret){
    			
    		}
    		
    	})
    	   	
    }
    /*
    function Map() {  
        this.elements = new Array();  
        //获取MAP元素个数  
        this.size = function() {  
            return this.elements.length;  
        };  
        //判断MAP是否为空  
        this.isEmpty = function() {  
            return (this.elements.length < 1);  
        };  
        //删除MAP所有元素  
        this.clear = function() {  
            this.elements = new Array();  
        };  
        //向MAP中增加元素（key, value)   
        this.put = function(_key, _value) {  
            this.elements.push( {  
                key : _key,  
                value : _value  
            });  
        };  
        //删除指定KEY的元素，成功返回True，失败返回False  
        this.remove = function(_key) {  
            var bln = false;  
            try {  
                for (i = 0; i < this.elements.length; i++) {  
                    if (this.elements[i].key == _key) {  
                        this.elements.splice(i, 1);  
                        return true;  
                    }  
                }  
            } catch (e) {  
                bln = false;  
            }  
            return bln;  
        };  
        //获取指定KEY的元素值VALUE，失败返回NULL  
        this.get = function(_key) {  
            try {  
                for (i = 0; i < this.elements.length; i++) {  
                    if (this.elements[i].key == _key) {  
                        return this.elements[i].value;  
                    }  
                }  
            } catch (e) {  
                return null;  
            }  
        };  
        //获取指定索引的元素（使用element.key，element.value获取KEY和VALUE），失败返回NULL  
        this.element = function(_index) {  
            if (_index < 0 || _index >= this.elements.length) {  
                return null;  
            }  
            return this.elements[_index];  
        };  
        //判断MAP中是否含有指定KEY的元素  
        this.containsKey = function(_key) {  
            var bln = false;  
            try {  
                for (i = 0; i < this.elements.length; i++) {  
                    if (this.elements[i].key == _key) {  
                        bln = true;  
                    }  
                }  
            } catch (e) {  
                bln = false;  
            }  
            return bln;  
        };  
        //判断MAP中是否含有指定VALUE的元素  
        this.containsValue = function(_value) {  
            var bln = false;  
            try {  
                for (i = 0; i < this.elements.length; i++) {  
                    if (this.elements[i].value == _value) {  
                        bln = true;  
                    }  
                }  
            } catch (e) {  
                bln = false;  
            }  
            return bln;  
        };  
        //获取MAP中所有VALUE的数组（ARRAY）  
        this.values = function() {  
            var arr = new Array();  
            for (i = 0; i < this.elements.length; i++) {  
                arr.push(this.elements[i].value);  
            }  
            return arr;  
        };  
        //获取MAP中所有KEY的数组（ARRAY）  
        this.keys = function() {  
            var arr = new Array();  
            for (i = 0; i < this.elements.length; i++) {  
                arr.push(this.elements[i].key);  
            }  
            return arr;  
        };  
    }
    
    function isExist(orderId){
    	var result = existId.get(orderId);
    	if(result != null){
    		return true;
    	}else{
    		return false;
    	}
    	
    }*/
     
   function isExist(orderId){
	   var result;
    	$.ajax({
    		url:contextPath+"/rest/order/isExist/"+orderId,
    		type:'GET',
    		async: false,
    		contentType:'application/json',
    		success:function(ret){
    			if(ret['data'] != null){
    				result = true;
    			}else{
    				result = false;
    			}
    			   			
    		},
    		error:function(ret){
    			
    		}
    		
    	})
    	return result;
    }
    
    function doSave(){
    	var data = formHelper2.getData();
    	var orderId = data['orderId'];

    	if(orderId != null && orderId != ""){
    		if(!isExist(orderId)){
//    			window.alert(data['orderId']);
    			var url = contextPath+"/rest/order/add";   	
            	$.ajax({
            		url:url,
            		type:'POST',
            		contentType:'application/json',
            		data:JSON.stringify({"orderItem":data}),
            		dataType:'json',
            		success:function(ret){
            			$('#formModal2').modal('hide');
            			orderGrid.reload();
            		},
            		error:function(ret){
            			
            		}
            		
            	})
    		}else{
    			window.alert("订单号已经存在！");
    		}
    		
    		/*var url = contextPath+"/rest/order/add";   	
        	$.ajax({
        		url:url,
        		type:'POST',
        		contentType:'application/json',
        		data:JSON.stringify({"orderItem":data}),
        		dataType:'json',
        		success:function(ret){
        			$('#formModal2').modal('hide');
        			orderGrid.reload();
        		},
        		error:function(ret){
        			
        		}
        		
        	})*/
    	}else{
    		window.alert("订单号不能为空！");
    	}
    	
    }
    
    function doSubmit(){
    	
		var data = formHelper.getData();
		data['status'] = 3;
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
    
    function doRevoke(){
    	
		var data = formHelper.getData();
		data['status'] = 1;
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
    var formHelper2;
    $(function(){
    	Metronic.init(); 
    	initOrderGrid();
    	initOrderItemGrid();
        $('#formModal').on("hidden.bs.modal", function() {
        	$("#orderForm")[0].reset();
        });
        $('#formModal2').on("hidden.bs.modal", function() {
        	$("#orderItemForm")[0].reset();
        });
        formHelper = new FormHelper("orderForm");
        formHelper2 = new FormHelper("orderItemForm");
    });
