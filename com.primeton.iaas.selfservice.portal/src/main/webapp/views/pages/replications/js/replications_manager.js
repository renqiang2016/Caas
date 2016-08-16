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
	
	$("#uploadBtn").click(function(){
        var dialog = $("#uploadDiv").clone().dialog({
            title: "附件上传",
            width : '75%',
            height : 500,
            modal : true
        });
        $('#fileupload', dialog).fileupload({
            dataType: 'json',
            progressall: function (e, data) {
                var progress = parseInt(data.loaded / data.total * 100, 10);
                $('#progress .progress-bar', dialog).css(
                    'width',
                    progress + '%'
                ).html(progress + '%');
                $("#msgDiv", dialog).html("处理中……");
            },
            add: function (e, data) {
                data.url = "ra/suspiciousCase/uploadTotal";
                data.submit();
                $("#uploadBtn", dialog).off('click').on('click', function () {
                    var id = getUrlParam('id');
                    data.url = "ra/suspiciousCase/upload?id="+id;
                    data.submit();
                    setTimeout(function(){handleUploadTable();}, 3000);//延迟执行刷新
                });
            },
            done: function (e, data) {
                var isTotal = data.url.indexOf("uploadTotal") > -1;
                var tip = isTotal ? "解析成功，请点击“确认上传”" : "上传";
                var result = data.result;
                var msg = "<b>" + tip + "</b>"
                var bar = $('#progress .progress-bar');
                bar.removeClass("progress-bar-warning progress-bar-success");
                if(!result.success){
                    msg = "<b>" + tip + "失败：</b>"+result.error;
                    bar.addClass("progress-bar-warning");
                    $("#uploadBtn", dialog).addClass("disabled");
                }else{
                    bar.addClass("progress-bar-success");
                    msg = "<b>" + tip + "成功：</b>";
                    if(isTotal){
                        $("#uploadBtn", dialog).removeClass("disabled");
                         
                    }
                }
                if(result.totalInfo){
                    msg += "<br>";
                    msg += "<b>提示信息：</b>" + result.totalInfo;
                }
                msg += "<br><b>文件名称：</b>" + data.files[0].name;
                $("#msgDiv", dialog).html(msg);
            }
        })
    })
	
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
        			$('#replicationModal').modal('hide');
        			rcsGrid.reload();
        		},
        		error:function(ret){
        			
        		}
        		
        	})
    	}
    	
    }
	
	/*function ajaxFileUpload() {  
		  
		$.ajaxFileUpload({  
		    url : "http://localhost:8080/com.primeton.iaas.selfservice.portal/rest/caas/replicationcontrollers/add",  
		    secureuri : false,  
		    data : {  
		        filePre : "feedback",  
		        p : new Date()  
		    },  
		    fileElementId : "file",  
		    dataType : "json",  
		    success : function(data) {  
		        if (data.status == "success") {  
		            //上传成功  
		        }  
		        switch(data.message){  
		         //解析上传状态  
		            case "0" : //上传成功  
		                       break;  
		            case "-1" : //上传文件不能为空  
		                      break;  
		            default: //上传失败  
		                 break;  
		        }  
		    },  
		    error : function(data) {  
		        //上传失败  
		    }  
		});*/
	
	function doUpload() {  
	     var formData = new FormData($( "#uploadForm" )[0]);  
	     $.ajax({  
	          url: 'http://localhost:8080/com.primeton.iaas.selfservice.portal/rest/caas/replicationcontrollers/add' ,  
	          type: 'POST',  
	          data: formData,  
	          async: false,  
	          cache: false,  
	          contentType: false,  
	          processData: false,  
	          success: function (returndata) {  
	              alert(123);  
	          },  
	          error: function (returndata) {  
	              alert(456);  
	          }  
	     });  
	}
	
	function UpladFile() {
	    var fileObj = document.getElementById("file").files[0]; // js 获取文件对象
	    var FileController = "http://localhost:8080/com.primeton.iaas.selfservice.portal/rest/caas/replicationcontrollers/add";                    // 接收上传文件的后台地址 
	
	    // FormData 对象
	    var form = new FormData($( "#uploadForm" )[0]);
	
	    // XMLHttpRequest 对象
	    var xhr = new XMLHttpRequest();
	    xhr.open("post", FileController, true);
	    xhr.onload = function () {
	       // alert("上传完成!");
	    };
	
	    xhr.upload.addEventListener("progress", progressFunction, false);
	    xhr.send(form);
	}
	
	function progressFunction(evt) {
	    var progressBar = document.getElementById("progressBar");
	    var percentageDiv = document.getElementById("percentage");
	    if (evt.lengthComputable) {
	        progressBar.max = evt.total;
	        progressBar.value = evt.loaded;
	        percentageDiv.innerHTML = Math.round(evt.loaded / evt.total * 100) + "%";
	        if(evt.loaded==evt.total){
	            alert("上传完成100%");
	        }
	    }
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
