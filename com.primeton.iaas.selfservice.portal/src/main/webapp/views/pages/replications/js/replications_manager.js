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

    var formHelper;
    $(function(){
    	Metronic.init(); 
    	initrcsGrid();
        $('#replicationModal').on("hidden.bs.modal", function() {
        	$("#replicationForm")[0].reset();
        });
        formHelper = new FormHelper("replicationForm");
    });
